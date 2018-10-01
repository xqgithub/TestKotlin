package example.com.testkotlin.haha.http

import android.content.Context
import com.google.gson.Gson
import com.safframework.log.L
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by beijixiong on 2018/9/30.
 * Flowable/Subscriber 模式（该模式是有背压处理的）
 * 1.背压策略的一个前提是异步环境，也就是说，被观察者和观察者处在不同的线程环境中
 * 2.背压（Backpressure）并不是一个像flatMap一样可以在程序中直接使用的操作符，他只是一种控制事件流速的策略
 */
abstract class ApiResponse2<T>(private val context: Context) : Subscriber<T> {
    abstract fun success(data: T)
    abstract fun failure(statusCode: Int, apiErrorModel: ApiErrorModel)


    override fun onSubscribe(s: Subscription?) {
        L.i("onSubscribe----->context = $context")
    }

    override fun onNext(t: T) {
        L.i("onNext----->")
        success(t)
    }

    override fun onComplete() {
        L.i("onComplete----->")
    }

    override fun onError(e: Throwable) {
        L.i("onError----->")
        if (e is HttpException) {
            val apiErrorModel: ApiErrorModel = when (e.code()) {
                ApiErrorType.INTERNAL_SERVER_ERROR.code ->
                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiErrorModel(context)
                ApiErrorType.BAD_GATEWAY.code ->
                    ApiErrorType.BAD_GATEWAY.getApiErrorModel(context)
                ApiErrorType.NOT_FOUND.code ->
                    ApiErrorType.NOT_FOUND.getApiErrorModel(context)
                else -> otherError(e)
            }
            failure(e.code(), apiErrorModel)
            return
        }

        val apiErrorType: ApiErrorType = when (e) {
            is UnknownHostException -> ApiErrorType.NETWORK_NOT_CONNECT
            is ConnectException -> ApiErrorType.NETWORK_NOT_CONNECT
            is SocketTimeoutException -> ApiErrorType.CONNECTION_TIMEOUT
            else -> ApiErrorType.UNEXPECTED_ERROR
        }
        failure(apiErrorType.code, apiErrorType.getApiErrorModel(context))
    }

    private fun otherError(e: HttpException) =
            Gson().fromJson(e.response().errorBody()?.charStream(), ApiErrorModel::class.java)


}
package example.com.testkotlin.haha.http

import android.content.Context
import com.google.gson.Gson
import com.safframework.log.L
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by beijixiong on 2018/9/30.
 * restful API请求响应的处理
 * 1.每个响应继承Observer，其中的泛型以适配返回的不同的数据体
 * 2.定义两个抽象方法success和failure，在使用的时候只需关注成功和失败这两种情况
 * 3.在onSubscribe即开始请求的时候显示Loading，在请求完成或出错时隐藏
 * 4.在onNext即Observer成功接收数据后直接调用success，在调用处可直接使用返回的数据
 * 5.在onError即请求出错时处理，此处包含两种情况：连接服务器成功但服务器返回错误状态码、网络或其它问题
 */
abstract class ApiResponse<T>(private val context: Context) : Observer<T> {

    abstract fun success(data: T)
    abstract fun failure(statusCode: Int, apiErrorModel: ApiErrorModel)

    override fun onSubscribe(d: Disposable) {
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
package example.com.testkotlin.haha.http

import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by beijixiong on 2018/9/30.
 */
object NetworkScheduler {
    fun <T> compose_observable(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())//每个请求都写一段这个，显得特别麻烦，所以进行以下简单封装
        }
    }

    fun <T> compose_flowable(): FlowableTransformer<T, T> {
        return FlowableTransformer { flowable ->
            flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())//每个请求都写一段这个，显得特别麻烦，所以进行以下简单封装
        }
    }
}
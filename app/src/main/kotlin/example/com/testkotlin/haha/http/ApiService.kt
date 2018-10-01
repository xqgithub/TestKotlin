package example.com.testkotlin.haha.http

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by beijixiong on 2018/9/30.
 * Api 集合
 *
 */
interface ApiService {
    //请添加相应的`API`调用方法
    @GET("users/{user}/repos")
    fun listRepos_Observable(@Path("user") user: String): Observable<List<Repo>> //每个方法的返回值即一个Observable

    @GET("users/{user}/repos")
    fun listrepos_Flowable(@Path("user") user: String): Flowable<List<Repo>> //每个方法的返回值即一个Observable

    @GET("users/{user}/repos")
    fun listrepos_Observable2(@Path("user") user: String): Observable<ResponseWrapper<List<Repo>>>  //每个方法的返回值即一个Observable
}
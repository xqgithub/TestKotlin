package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import example.com.testkotlin.haha.http.*
import kotlinx.android.synthetic.main.activity_retrofit2rxjava2.*


/**
 * Created by beijixiong on 2018/9/30.
 */
class Retrofit2Rxjava2Activity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        submit.setOnClickListener {
            fetchRepo_Observable()
//            fetchRepo_Flowable()
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_retrofit2rxjava2
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    private fun fetchRepo_Observable() {
        //链式调用
        ApiClient.instance.service.listRepos_Observable(inputUser.text.toString())   //ApiService中的方法
                .compose(NetworkScheduler.compose_observable())                      //线程切换处理
                .bindUntilEvent(this, ActivityEvent.DESTROY)              //生命周期管理
                .subscribe(object : ApiResponse<List<Repo>>(this) {       //对象表达式约等于Java中的匿名内部类
                    override fun success(data: List<Repo>) {              //请求成功，此处显示一些返回的数据
                        userName.text = data[0].owner.login
                        repoName.text = data[0].name
                        description.text = data[0].description
                        url.text = data[0].html_url
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) { //请求失败，此处直接显示Toast
                        L.e("apiErrorModel.message----->${apiErrorModel.message}")
                    }
                })
    }

    private fun fetchRepo_Flowable() {
        //链式调用
        ApiClient.instance.service.listrepos_Flowable(inputUser.text.toString())//ApiService中的方法
                .compose(NetworkScheduler.compose_flowable()) // 线程切换处理
//                .bindUntilEvent(this, ActivityEvent.DESTROY)              //生命周期管理
                .subscribe(object : ApiResponse2<List<Repo>>(this) {    //对象表达式约等于Java中的匿名内部类
                    override fun success(data: List<Repo>) {               //请求成功，此处显示一些返回的数据
                        userName.text = data[0].owner.login
                        repoName.text = data[0].name
                        description.text = data[0].description
                        url.text = data[0].html_url
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {//请求失败，此处直接显示Toast
                        L.e("apiErrorModel.message----->${apiErrorModel.message}")
                    }
                })
    }

    /**
     *  使用RequestCallback方式
     */
    private fun fetchRepo_Observable2() {
        //链式调用
        ApiClient.instance.service.listrepos_Observable2(inputUser.text.toString()) //ApiService中的方法
                .compose(NetworkScheduler.compose_observable())                    // 线程切换处理
                .bindUntilEvent(this, ActivityEvent.DESTROY)              //生命周期管理
                .subscribe(object : RequestCallback<List<Repo>>(this) {
                    override fun success(data: List<Repo>) {
                        userName.text = data[0].owner.login
                        repoName.text = data[0].name
                        description.text = data[0].description
                        url.text = data[0].html_url
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        L.e("apiErrorModel.message----->${apiErrorModel.message}")
                    }

                })
    }


}





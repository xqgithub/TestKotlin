package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
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
            fetchRepo()
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

    private fun fetchRepo() {
        //链式调用
        ApiClient.instance.service.listRepos(inputUser.text.toString())   //GitHubService中的方法
                .compose(NetworkScheduler.compose())                      //线程切换处理
//                .bindUntilEvent(this, ActivityEvent.DESTROY)              //生命周期管理
                .subscribe(object : ApiResponse<List<Repo>>(this) {       //对象表达式约等于Java中的匿名内部类
                    override fun success(data: List<Repo>) {              //请求成功，此处显示一些返回的数据
                        userName.text = data[0].owner.login
                        repoName.text = data[0].name
                        description.text = data[0].description
                        url.text = data[0].html_url
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) { //请求失败，此处直接显示Toast
                        L.i("apiErrorModel.message----->${apiErrorModel.message}")
                    }
                })
    }


}
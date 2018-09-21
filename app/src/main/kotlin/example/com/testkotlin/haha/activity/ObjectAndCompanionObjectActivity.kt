package example.com.testkotlin.haha.activity

import android.os.Bundle
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import example.com.testkotlin.haha.utils.LazySingleton
import example.com.testkotlin.haha.utils.SimpleSington

/**
 * Created by beijixiong on 2018/9/21.
 * 1.object和companion object关键字
 */
class ObjectAndCompanionObjectActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SimpleSington.a()
        LazySingleton.instance.a()
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_objectandcompanionobject
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}
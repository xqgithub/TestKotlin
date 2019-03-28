package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ankocommons.*
import org.jetbrains.anko.*

/**
 * Created by beijixiong on 2018/10/15.
 * 介绍commons的使用
 */
class AnkoToCommons : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn1.setOnClickListener {
            //启动，并且传递参数
//            startActivity<AnkoToLayout>("name" to "路飞", "age" to 19)
            //
            startActivity(intentFor<AnkoToLayout>("name" to "路飞", "age" to 19).singleTop())
        }

        //快捷 浏览器，发短信，分享，发邮件操作
        btn2.setOnClickListener {
            browse("https://www.youtube.com")
        }

        //Dimensions类，重要的方法主要是单位换算
        btn3.setOnClickListener {
            //dp转px
            L.i("dip2px-----> ${dip(100)}")
            //px转dp
            L.i("px2dip-----> ${px2dip(100)}")
        }


    }

    override fun getLayoutId(): Int {
        return R.layout.activity_ankocommons
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

}
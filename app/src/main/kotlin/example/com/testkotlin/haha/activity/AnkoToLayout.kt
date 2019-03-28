package example.com.testkotlin.haha.activity

import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ankolayout.*

/**
 * Created by beijixiong on 2018/10/15.
 * layout库介绍
 */
class AnkoToLayout : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_ankolayout
    }

    override fun initView() {

    }

    override fun initData() {
        var name = intent?.extras?.getString("name")
        var age = intent?.extras?.getInt("age")
        tv_show.text = "name:$name,age:$age"
    }

    override fun initListener() {
    }
}
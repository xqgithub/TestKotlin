package example.com.testkotlin.haha.activity

import android.os.Bundle
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/19.
 * 属性和字段
 */
class AttributesFieldsActivity : BaseActivity() {


    var name: String = "aaa"
    var state: String? = null
    val street: String = "ccc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_attributesfields
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        state = "bbb"
    }

    override fun initListener() {
    }


}
package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/19.
 * 1.属性和字段
 * 2.可选参数和默认值
 */
class AttributesFieldsActivity : BaseActivity() {


    var name: String = "aaa"
    var state: String? = null
    val street: String = "ccc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        /**
         * 可选参数在一定程度上面可以实现方法重载
         */
        optionalParameter()
        optionalParameter(10)
        optionalParameter(10, 11)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_attributesfields
    }

    override fun initView() {
    }

    override fun initData() {
        state = "bbb"
    }

    override fun initListener() {
    }

    /**
     * 可选参数方法
     * a和b都有默认值：方法中不传参数 读取默认值；方法中传了参数读取传入的参数值
     */
    fun optionalParameter(a: Int = 0, b: Int = 1) {
        if (a > b) L.i("a是较大的值 $a") else L.i("b是较大的值 $b")
    }

}
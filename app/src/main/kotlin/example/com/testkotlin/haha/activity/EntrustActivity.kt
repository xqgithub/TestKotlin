package example.com.testkotlin.haha.activity

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import com.safframework.log.i
import example.com.testkotlin.R
import example.com.testkotlin.haha.app.MyApp
import example.com.testkotlin.haha.base.BaseActivity
import example.com.testkotlin.haha.domain.EntrustBaseImpl
import example.com.testkotlin.haha.utils.SPreferenceUtils

/**
 * Created by beijixiong on 2018/9/21.
 * 委托和委托属性
 * 1.EntrustBaseDerived委托给了EntrustBase 不然就需要重写方法a()
 * 2.委托属性  语法：val/var <属性名>: <类型> by <表达式>
 * 3.有一种属性，在使用的时候每次都要手动实现它，但是可以做到只实现一次，并且放到库中，一直使用，这种属性称为委托属性
 */
class EntrustActivity : BaseActivity() {


    var test_sp: String by SPreferenceUtils(MyApp.context!!, "xiaoqueque", "Company", "路飞")//默认存的值是路飞


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val entrustbaseimpl = EntrustBaseImpl("小雀雀")
//        val entrustbasederived = EntrustBaseDerived(entrustbaseimpl)
//        entrustbasederived.a()

//        entrustbaseimpl.b()
//        entrustbaseimpl.c()
//        entrustbaseimpl.d()

//        var map = mapOf("name" to "John Doe", "age" to 25)
//        var map = mutableMapOf<String, Any>()
//        map["name"] = "queque"
//        map["age"] = 77
//        entrustbaseimpl.e(map)

        test_sp = "索隆"//这里改变了
        L.i("----->$test_sp")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_entrust
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}
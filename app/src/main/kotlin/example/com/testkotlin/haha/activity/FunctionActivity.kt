package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/22.
 */
class FunctionActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val result = testFunction()
//        L.i("result-----> $result")
//
//        val result2 = testFunction2()
//        L.i("result2-----> $result2")

//        val result3 = testFunction3(strings = *arrayOf("a", "b", "c"))
//        L.i("result3-----> $result3")

        val result4 = "小雀雀" testFunction4 "路飞"
        L.i("result3-----> $result4")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_function
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    /**
     * 1.函数使用 fun 关键字声明
     * 2.参数使用 Pascal 表示法定义，即 name: type。参数用逗号隔开。每个参数必须有显式类型
     * 3.函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量
     * 4.覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值
     */
    fun testFunction(x: Int = 7): Int {
        return 2 * x
    }

    /**
     *1.如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用命名参数调用该函数来使用
     *2.不过如果最后一个 lambda 表达式参数从括号外传给函数函数调用，那么允许默认参数不传值
     */
    fun testFunction2(x: Int = 2, y: Int = 1): Int {
        return 2 * (x + y)
    }

    /**
     *1.可以通过使用星号操作符将可变数量参数（vararg） 以命名形式传入
     */
    fun testFunction3(vararg strings: String): String {
        return strings[0]
    }

    /**
     * 中缀表示法
     * 1.标有 infix 关键字的函数也可以使用中缀表示法（忽略该调用的点与圆括号）调用
     * 2.满足条件
     *   a.它们必须是成员函数或扩展函数
     *   b.它们必须只有一个参数
     *   c.其参数不得接受可变数量的参数且不能有默认值
     * 3.中缀函数调用的优先级低于算术操作符、类型转换以及 rangeTo 操作符
     * 4.中缀函数调用的优先级高于布尔操作符 && 与 ||、is- 与 in- 检测以及其他一些操作符
     */
    infix fun String.testFunction4(x: String): String = this + "_____" + x


}
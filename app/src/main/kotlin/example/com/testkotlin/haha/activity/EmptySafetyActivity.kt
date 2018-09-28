package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/27.
 * 空安全
 */
class EmptySafetyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        test_emptysafety2()
        test_emptysafety3()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_emptysafety
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }


    /**
     * 要定义一个可空类型的变量时，即在定义变量的类型后面加上?符号就行了
     */
    fun test_emptysafety1() {
        //定义一个不可为空的变量，用var修饰的变量可以被重新赋值，用val修饰的变量则不能，但是不能赋值为null
        var a: Int = 12
        val b: Int = 13
        a = 20//a = null(不能复制为null)
//      b = 20 //不能被重新赋值
        /**
         * 定义可空类型的变量,即变量可以被赋值为null
         * 定义格式为：修饰符 变量名 ： 类型? = 值
         */
        var nullA: Int? = 12
        val nullB: Int? = 13
        nullA = null
        if (nullA == null) {
            L.i("nullA = $nullA")
        }
    }

    /**
     * 1.if...else...判断  是否为空
     * 2.使用符号?.判断  如果可空类型变量为null时，返回null
     * 3.链式调用
     * 4.变量?.let{ ... }
     */
    fun test_emptysafety2() {
        var str: String? = "123456"
        str = null
        if (str == null) {
            L.i("变量str为空")
        } else {
            L.i("str.length => ${str.length}")
        }

        var str2: String? = "123456"
        str2 = null
        L.i("${str2?.length}")   // 当变量str为null时，会返回空(null)
    }

    /**
     * 1. ?:操作符  当我们定义了一个可空类型的变量时，如果该变量不为空，则使用，反之使用另外一个不为空的值
     * 2. !!操作符  !!操作符可谓是给爱好空引用异常（NullPointException）的开发者使用，因为在使用一个可空类型变量时，在该变量后面加上!!操作符，会显示的抛出NullPointException异常
     * 3. as?操作符 其实这里是指as操作符，表示类型转换，如果不能正常转换的情况下使用as?操作符。当使用as操作符的使用不能正常的转换的情况下会抛出类型转换（ClassCastException）异常，而使用as?操作符则会返回null,但是不会抛出异常
     */
    fun test_emptysafety3() {
        val testStr: String? = null
        var length = 0
        // 例： 当testStr不为空时，输出其长度，反之输出-1
        // 传统写法
        length = if (testStr != null) testStr.length else -1
        // ?: 写法
        length = testStr?.length ?: -1
        L.i("length = $length")

        val testStr2: String? = null
        L.i("testStr2=${testStr2!!.length}")
    }

}
package example.com.testkotlin.haha.activity

import android.content.Intent
import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/26.
 * 内联函数
 */
class InlineFunctionActivity : BaseActivity() {

    val mActivity = InlineFunctionActivity@ this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        test_inline2()
//        jumpToActivity<FunctionActivity>()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_inlinefunction
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    /**
     * 1.使用高阶函数会带来一些运行时的效率损失：每一个函数都是一个对象，并且会捕获一个闭包。 即那些在函数体内会访问到的变量。 内存分配（对于函数对象和类）和虚拟调用会引入运行时间开销
     * 2.但是在许多情况下通过内联化 lambda 表达式可以消除这类的开销
     * 3.对频繁调用的代码内联化，可以提高代码效率降低调用成本
     * 4.内联可能导致编译器生成的代码增加,但如果使用得当(不内联大函数),在性能上有很大提升,尤其是在循环的megamorphic处调用
     * 5.内联目前主要还是应用在 函数参数是lambda表达式的代码中
     * 6.noinline 修饰符标  可以禁止
     */
    inline fun test_inline1(a: Int, b: Int, c: (a: Int, b: Int) -> Int) {
        var d = c(a, b)
        L.i("d = $d")
    }


    fun test_inline2() {
        print("开始************")
        test_inline1(3, 4, { a: Int, b: Int -> a * b })
        print("结束************")
    }

    /**
     * 非局部返回
     * 1.一个函数中，如果存在一个lambda表达式，在该lambda中不支持直接进行return退出该函数
     * 2.如果 lambda 表达式传给的函数是内联的，该 return 也可以内联，所以它是允许
     *
     */
    fun test_Non_local_return(ints: List<Int>): Boolean {
        ints.forEach {
            if (it == 0) return true // 从 test_Non_local_return 返回
        }
        return false
    }
    /**
     * crossinline
     * crossinline 的作用是让被标记的lambda表达式不允许非局部返回
     */

    /**
     * 具体化的类型参数
     * 使用 reified 修饰符来限定类型参数，现在可以在函数内部访问它了， 几乎就像是一个普通的类一样
     */

    private inline fun <reified T> jumpToActivity() {
        val intent = Intent()
        intent.setClass(mActivity, T::class.java)//获取intent对象
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)// 获取class是使用::反射
    }


}
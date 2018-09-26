package example.com.testkotlin.haha.activity

import android.app.Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import example.com.testkotlin.haha.utils.showLongToastSafe
import kotlinx.android.synthetic.main.activity_function.*
import org.jetbrains.anko.textColor

/**
 * Created by beijixiong on 2018/9/22.
 * 函数
 * 高级函数和Lambda表达式
 */
class FunctionActivity : BaseActivity() {

    val mActivity: Activity = FunctionActivity@ this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val result = testFunction()
//        L.i("result-----> $result")
//
//        val result2 = testFunction2()
//        L.i("result2-----> $result2")

//        val result3 = testFunction3(strings = *arrayOf("a", "b", "c"))
//        L.i("result3-----> $result3")

//        val result4 = "小雀雀" testFunction4 test_lambda(3, 4).toString()
//        L.i("result3-----> $result4")


//        test_lambda1()
//        test_lambda2(1, 2)
//        test_lambda3(2, 3)

//        val ints = arrayListOf(1, 2, 3, 4, 5)
//        var newInts = ints.test_HSFunction1 { it.toString() + "谢谢观赏" }
//        L.i("newInts-----> $newInts")
//        L.i("test_HSFunction2----->" + test_HSFunction2(10, { b -> b > 5 }))
//        L.i("test_HSFunction2----->" + test_HSFunction2(2, { it > 5 }))
//        test_HSFunction4()

//        test_Run1()
//        test_Run2()
//        test_Run3()
//        test_with()
//        test_apply()
//        test_let()
//        test_takeif()
//        test_takeUnless()
        test_repeat()


//        val result5 = test_closure1(4)()
//        L.i("test_closure1----->$result5")
//
//        test_closure2()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_function
    }

    override fun initView() {
        tv_function_apply.text
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


    /**
     * Lambda 表达式
     * 1.lambda表达式就是一个匿名函数
     *  a.表达式总是被大括号括着
     *  b.其参数(如果存在)在 -> 之前声明(参数类型可以省略)
     *  c.函数体(如果存在)在 -> 后面
     * 2.在lambda中不可用直接使用return
     * 3.可以使用return+label这种形式
     * 4.lambda中最后一个表达式的值是默认的返回值
     * 5.在使用Lambda表达式的时候，可以用下划线(_)表示未使用的参数，表示不处理这个参数
     */
    //无参数样式
    val test_lambda1 = { L.i("这是lambda无参数样式") }
    //有参数样式
    val test_lambda2: (Int, Int) -> Unit = { a, b ->
        L.i("$a + $b = ${a + b}")
    }
    val test_lambda3 = { a: Int, b: Int ->
        L.i("$a + $b = ${a + b}")
    }

    /**
     * 高阶段函数
     * 1.参数是函数，或者返回值是函数
     * 2.参数也可以是lambda表达式
     * 3.it是在当一个高阶函数中Lambda表达式的参数只有一个的时候可以使用it来使用此参数。it可表示为单个参数的隐式名称，是Kotlin语言约定的。
     */
    fun <T, R> List<T>.test_HSFunction1(transform: (T) -> R): List<R> {
        val result = arrayListOf<R>()
        for (item in this)
            result.add(transform(item))
        return result
    }

    //it 的例子
    fun test_HSFunction2(num1: Int, bool: (Int) -> Boolean): Int {
        return if (bool(num1)) num1 else 0
    }

    //自定义高阶段函数
    fun test_HSFunction3(num1: Int, num2: Int, result: (Int, Int) -> Int): Int {
        return result(num1, num2)
    }

    //自定义高阶段函数
    fun test_HSFunction4() {
        //两数相加
        val result1 = test_HSFunction3(3, 4, { a, b -> a + b })
        //两数相减
        val result2 = test_HSFunction3(3, 4, { a, b -> a - b })
        //两数想乘
        val result3 = test_HSFunction3(3, 4, { a, b -> a * b })
        //两数相除
        val result4 = test_HSFunction3(3, 4, { a, b -> a / b })
        L.i("result1----->$result1")
        L.i("result2----->$result2")
        L.i("result3----->$result3")
        L.i("result4----->$result4")
    }

    /**
     * Kotlin 标准库扩展函数集合(高阶段函数) 详情 请参考：Kotlin 扩展函数详解与应用 第四点   https://blog.csdn.net/ComWill/article/details/77206508
     * 1.apply      接受一个lambda表达式作为参数，并在apply调用时立即执行，apply返回原来的对象
     * 2.let        let 和 apply 类似， 唯一的不同是返回值，let返回的不是原来的对象，而是闭包里面的值
     * 3.with       with 是一个顶级函数， 当你想调用对象的多个方法但是不想重复对象引用
     * 4.run        run 是 with和let 的组合
     * 5.lazy       lazy延迟运算，当第一次访问时，调用相应的初始化函数
     * 6.use        use 用在 Java 上的 try-with-resources 表达式上
     * 7.reapt      顾名思义，repeat 就是重复的意思，它接受函数和整数作为参数，函数会被调用 n 次，这个函数避免写循环
     * 8.require/assert/check     用来检测条件是否为true, 否则抛出异常。 其中 require 用在参数检查； 而 assert/check 用在内部状态检查，assert 抛出 AssertionException 、 check 抛出 IllegalStateException
     * 9.takeif     传入一个你希望的一个条件，如果对象符合你的条件则返回自身，反之，则返回null
     */
    //1.TODO函数 这个函数不是一个高阶函数，它只是一个抛出异常以及测试错误的一个普通函数。
    //2.run()函数 三种用法
    //a.当我们需要执行一个代码块的时候就可以用到这个函数,并且这个代码块是独立的。即我可以在run()函数中写一些和项目无关的代码，因为它不会影响项目的正常运行。
    fun test_Run1() {
        val a = "kotlin"
        run {
            val a = "java"
            L.i("a = $a")
        }
        L.i("a = $a")
    }

    //b.因为run函数执行了我传进去的lambda表达式并返回了执行的结果，所以当一个业务逻辑都需要执行同一段代码而根据不同的条件去判断得到不同结果的时候。可以用到run函数
    fun test_Run2() {
        val index = 0
        val num = run {
            when (index) {
                0 -> "kotlin"
                1 -> "java"
                2 -> "php"
                3 -> "javaScript"
                else -> "none"
            }
        }.length
        L.i("num = $num")
    }

    //c. T.run()函数 所以当我们传入的lambda表达式想要使用当前对象的上下文的时候，我们可以使用这个函数
    fun test_Run3() {
        val str = "kotlin"
        str.run {
            L.i("length = $length")
        }
    }

    //3.with()函数 其实with()函数和T.run()函数的作用是相同的
    fun test_with() {
        val str = "kotlin"
        with(str) {
            L.i("length = $length")
        }
    }

    //4.T.apply()函数  和T.run()一样,  不同的是T,apply执行完了后，返回了自身对象
    fun test_apply() {
        tv_function_apply
                .apply {
                    text = "apply方法测试"
                    textSize = 16f
                    textColor = ContextCompat.getColor(mActivity, R.color.update_press_bg)
                }.apply {
                    setOnClickListener {
                        mActivity.showLongToastSafe("我是apply测试方法")
                    }
                }
    }

    //5.T.also()函数  T.also函数来说，它和T.apply很相似   不同的是T.also中只能使用it调用自身,而T.apply中只能使用this调用自身
    //6.T.let()函数   T?.let()可以用来做非空判断
    fun test_let() {
        "kotlin".let {
            L.i("原字符串：$it")         // kotlin
            it.reversed()
        }.let {
            L.i("反转字符串后的值：$it")     // niltok
            it.plus("-java")
        }

        "kotlin".also {
            L.i("原字符串：$it")     // kotlin
            it.reversed()
        }.also {
            L.i("反转字符串后的值：$it")     // kotlin
            it.plus("-java")
        }

        "kotlin".apply {
            L.i("原字符串：$this")     // kotlin
            this.reversed()
        }.apply {
            L.i("反转字符串后的值：$this")     // kotlin
            this.plus("-java")
        }
    }

    //7.T.takeIf()函数   传入一个你希望的一个条件，如果对象符合你的条件则返回自身，反之，则返回null。
    fun test_takeif() {
        val str = "kotlin"
        val result = str.takeIf {
            it.startsWith("ko")
        }
        L.i("result = $result")
    }

    //8.T.takeUnless()函数   这个函数的作用和T.takeIf()函数的作用是一样的。只是和其的逻辑是相反的
    fun test_takeUnless() {
        val str = "kotlin"
        val result = str.takeUnless {
            it.startsWith("ko")
        }
        L.i("result = $result")
    }

    //9.repeat()函数 重复相关的一个函数
    fun test_repeat() {
        repeat(5) {
            L.i("我是重复的第${it + 1}次，我的索引为：$it")
        }
    }


    /**
     * 闭包
     * 所谓闭包，即是函数中包含函数，这里的函数我们可以包含(Lambda表达式，匿名函数，局部函数，对象表达式)
     */
    //让函数返回一个函数，并携带状态值
    fun test_closure1(a: Int): () -> Int {
        var b = 3
        return fun(): Int {
            return a + b
        }
    }

    //引用外部变量，并改变外部变量的值
    fun test_closure2() {
        var sum: Int = 0
        val arr = arrayOf(1, 3, 5, 7, 9)
        arr.filter { it < 7 }.forEach({ sum += it })
        L.i("sum 的值是 $sum")
    }


}
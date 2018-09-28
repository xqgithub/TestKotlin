package example.com.testkotlin.haha.activity

import JavaAlternately
import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import java.util.*

/**
 * Created by beijixiong on 2018/9/28.
 * Kotlin 中调用 java 代码
 */
class JavaFromKotlinActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        test_JavaFromKotlin1(listOf(1, 2, 3))
//        test_JavaFromKotlin2()
//        test_JavaFromKotlin3()
//        test_JavaFromKotlin5()
//        test_JavaFromKotlin6()
        test_JavaFromKotlin7()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_javafromkotlin
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    /**
     * Kotlin使用Java的集合类的示例
     */
    fun test_JavaFromKotlin1(source: List<Int>) {
        //ArrayList 是java中的方法
        val list = ArrayList<Int>()
        // kotlin的for循环对Java集合类同样有效
        for (item in source) {
            list.add(item)
        }
        L.i("list = $list")

        // kotlin操作符对java同样有效
        for (i in 0..(source.size - 1)) {
            //get和set访问器被调用(见下文)
            L.i("source = ${source[i]}")
        }
    }

    /**
     * Getter和Setter方法
     * 1.java字段成员的getter和setter方法遵循Java惯例(即名称以get开头的无参数方法和以set开头的单参数方法),它们在Kotlin中都被表示为kotlin属性,可以直接调用
     * 2.如果Java类某字段只有一个setter,在Kotlin中不会作为kotlin属性!
     * 3.因为Kotlin目前不支持只写(set-only)属性!
     */
    fun test_JavaFromKotlin2() {
        val calendar = Calendar.getInstance()
        //相当于调用calendar.getFirstDayOfWeek()
        if (calendar.firstDayOfWeek == Calendar.SUNDAY) {
            //相当于调用calendar.setFirstDayOfWeek(Calendar.MONDAY)
            calendar.firstDayOfWeek = Calendar.MONDAY
        }
    }

    /**
     * 返回void的方法
     *1.一个Java方法返回void,那么从Kotlin调用时中返回Unit
     */
    fun test_JavaFromKotlin3() {
        val v = JavaAlternately.vid()
        L.i("v = $v") // 输出kotlin.Unit
    }

    /**
     * Java标识符(Kotlin关键字)进行转义
     * 1.一些Kotlin关键字在Java中是有效标识符(如in,object,is等),Java类库使用了Kotlin关键字作为方法名,可用反引号(`)转义java方法名,然后在kotlin调用该方法
     */
    fun test_JavaFromKotlin4() {
        //is()是java方法名/函数名,但is是kotlin关键字,所以在kotlin中需要添加反引号`转义
    }

    /**
     * Java空安全和平台类型
     * 1.kotlin对平台类型的空检查(Null-checks)会放宽,因此它们在kotlin中的安全性与在Java中一样!
     */

    fun test_JavaFromKotlin5() {
        val list = ArrayList<String>() // 非空(构造函数结果)
        list.add("Item")
        val size = list.size // 非空(原生 int)
        val item = list[0] // 推断为平台类型(普通Java对象)
        //当调用平台类型的方法时,Kotlin不会在编译时检查可空性null错误,但在运行时调用可能报错,出现空指针异常NullPointerException或者Kotlin断言阻止null传播!
        L.i("item = ${item.substring(1)}") // 允许,如果item == null,可能会抛出异常
    }

    /**
     * Java类型映射
     */

    /**
     * 在Kotlin中的Java泛型
     */

    /**
     * Java数组
     * 与Java数组不同,Kotlin数组是不型变的,
    意味着Kotlin不允许把Array<String>赋值给Array<Any>,从而避免了运行时出错!
    Kotlin也禁止把子类数组作为超类/父类数组传给Kotlin函数/方法,
    但是对于Java方法是允许的(通过Array<(out) String>!平台类型)!
    需要变通方法来与Java代码交互,每种原生/基本类型数组都有对应的kotlin类(IntArray,DoubleArray,CharArray等)!
     */
    fun test_JavaFromKotlin6() {
        //Kotlin代码
        val javaObj = JavaAlternately()
        val array = intArrayOf(0, 1, 2, 3)
        javaObj.removeIndices(array)  //将int[]传给java方法
    }

    /**
     * Java参数个数可变
     * Java类有时声明参数个数可变(varargs)的方法来使用索引
     */
    fun test_JavaFromKotlin7() {
        //kotlin代码,用展开运算符*传递IntArray到java方法:
        val javaObj = JavaAlternately()
        val array = intArrayOf(0, 1, 2, 3)
        javaObj.removeIndices2(*array)
    }


}
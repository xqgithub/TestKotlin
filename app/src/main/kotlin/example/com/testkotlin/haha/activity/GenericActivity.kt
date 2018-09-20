package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.safframework.log.L
import example.com.testkotlin.R

/**
 * Created by XQ on 2018/1/6.
 * 泛型
 */
class GenericActivity : AppCompatActivity() {

    val TAG: String = "GenericActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dataclass)

//        test0()
//        test1()
        test2()
//        test3()
    }

    /**
     * 泛型函数
     */
    fun <T> doPrintln(content: T) {
        when (content) {
            is Int -> println(content % 10)
            is String -> println(content.toUpperCase())
            else -> println("T is not Int and String")
        }
    }

    fun test0() {
        val age = 23
        val name = "Jone"
        val person = true
        doPrintln(age) // 打印：3
        doPrintln(name) // 打印：JONE
        doPrintln(person) // 打印：T is not Int and String
    }


    /**
     * 泛型类
     * 果既将泛型作为函数参数，又将泛型作为函数的输出，那就既不用 in 或 out
     */
    class Box<T>(t: T) {
        var value = t
    }

    fun test1() {
        var boxInt = Box<Int>(10)
        var boxString = Box<String>("Jone")
        println(boxInt.javaClass) // 打印：class com.teaphy.generic.Box
        println(boxString.javaClass) // 打印：class com.teaphy.generic.Box
    }


    /**
     * 声明处的类型变异
     * 生产者 out(协变)
     * 如果你的类是将泛型作为内部方法的返回，那么可以用 out
     */
    class Box1<out T>(val t: T) {
        fun foo(): T {
            return t
        }
    }

    /**
     * 消费者 in（逆变）
     * 如果你的类是将泛型对象作为函数的参数，那么可以用 in
     */
    class Box2<in T>() {
        fun foo(t: T): String {
            if (t is String) {
                return "这是一个String类型"
            } else {
                return "这不是一个String类型"
            }
        }
    }

    fun test2() {
        var box1: Double = Box1(1.00).foo()
        var box2 = Box2<Any>().foo("1")
        L.i("Box1 中返回的是 ")
        L.i("Box2 中返回的是 $box2")//由于String是Any的是一个子类，所以是可行的。
    }

    fun test3() {
        var mutable = mutableListOf<String>()
        mutable.add("1111")
        println(mutable)
    }


}


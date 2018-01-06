package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
     *泛型类
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
     * 消费者 in
     */
    class Box1<out T>(val t: T) {
        fun foo(): T {
            return t
        }
    }

    /**
     * 生产者 out
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
        var boxInt = Box1<Int>(10)
        var boxString = Box2 <String>()
//        println(boxInt.foo())
        println(boxString.foo("1"))
    }

}


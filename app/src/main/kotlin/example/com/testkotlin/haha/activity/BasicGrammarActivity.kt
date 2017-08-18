package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import example.com.testkotlin.R

/**
 *基本语法
 */
class BasicGrammarActivity : AppCompatActivity() {

    val TAG: String = "BasicGrammarActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_grammar)

//        testLocalvariables()
//        testArray(stringArray1)
//        Log.i(TAG, testAutomaticCasts("12").toString())
//        testForCycle(stringArray)
        testWhen(1)
    }

    /**
     *定义函数
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 定义局部变量
     */
    fun testLocalvariables() {
        //常量
        val a: Int = 1
        val b = 1  // `Int` 类型自动推断
        val c: Int // 如果没有初始值，声明常量时，常量的类型不能省略
        c = 1 // 明确赋值
        Log.i(TAG, a.toString())
        Log.i(TAG, b.toString())
        Log.i(TAG, c.toString())
        //变量
        var x = 5 // `Int` 类型自动推断（ 5 默认是 `Int` ）
        x += 1
        Log.i(TAG, x.toString())
    }

    /**
     *字符串数组定义
     */
    fun testArray(args: Array<String>) {
        if (args.size == 0) {
            Log.i(TAG, "Array is no datas")
            return
        } else {
            Log.i(TAG, "First argument:" + args[0])
        }
    }

    /**
     *条件判断
     */
    fun testConditionalJudgment(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    /**
     *运算符用于类型判断
     */
    fun testAutomaticCasts(obj: Any): Int? {
        if (obj is String) {
            // `obj` 在该条件判断分支内自动转换成 `String`
            return obj.length
        }
        // 在离开类型判断分支后， `obj` 仍然是 `Any` 类型
        return null
    }

    /**
     *for循环
     */
    fun testForCycle(args: Array<String>) {
        for (i in args.indices) {
            Log.i(TAG, "args----->" + args[i])
        }
    }

    /**
     *when表达式
     */
    fun testWhen(obj: Any) {
        when (obj) {
            1 -> println("One")
            "Hello" -> println("Greeting")
            is Long -> println("Long")
            !is String -> println("Not a string")
            else -> println("Unknown")
        }
    }


    /**
     *测试数据
     */
    //    val stringArray = arrayOf("UK", "Germany", "Italy")
    val stringArray1 = emptyArray<String>()//长度为0的空数组
}

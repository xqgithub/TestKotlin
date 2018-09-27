package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.safframework.log.L
import example.com.testkotlin.R

/**
 * Created by XQ on 2018/01/03.
 * 基本语法
 */
class BasicGrammarActivity : AppCompatActivity() {

    val TAG: String = "BasicGrammarActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_grammar)
        L.init(this.javaClass)//加载日志类TAG

//        testLocalvariables()
//        testArray(stringArray1)
//        Log.i(TAG, testAutomaticCasts("12").toString())
//        testForCycle(stringArray)
//        testWhen(1)
//        testFor(stringArray, 2)
//        testRanges(4, 7)
//        testContains(stringArray, "UK")
//        testMap()
        test_equality()
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
//        Log.i(TAG, a.toString())
//        Log.i(TAG, b.toString())
//        Log.i(TAG, c.toString())
        L.i(a.toString())
        L.i(b.toString())
        L.i(c.toString())
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
     * 使用 for 循环
     */
    fun testFor(args: Array<String>, type: Int) {
        if (type == 1) {
            for (arg in args) {
                println("this is type 1：" + arg)
            }
        } else if (type == 2) {
            for (i in args.indices) {
                println("this is type 2：" + args[i])
            }
        }

    }

    /**
     *使用区间（ranges）
     */
    fun testRanges(type: Int, i: Int) {
        if (type == 1) {
            if (i in 1..10) {// equivalent of 1 <= i && i <= 10
                L.i(i.toString() + ":in the range")
            } else if (i !in 1..10) {
                L.i(i.toString() + ":not in the range")
            }
        } else if (type == 2) {
            for (i in 1..10) {//遍历数字
                L.i("在1-10范围内的数值：" + "$i")
            }
        } else if (type == 3) {
            for (i in 10 downTo 1) {//遍历数字颠倒顺序
                L.i("在1-10范围内的数值：" + "$i")
            }
        } else if (type == 4) {
            for (i in 10 downTo 1 step 2) {//任意进行数量的迭代
                L.i("在1-10范围内的数值：" + "$i")
            }
        }
    }

    /**
     * 集合contains的用法
     */
    fun testContains(args: Array<String>, arg: String) {
        if (arg in args) {
            println(arg + "----->在该集合内")
        } else {
            println(arg + "----->不在该集合内")
        }
    }

    /**
     * 习惯用法
     * 遍历 map/list 中的键值对
     */
    fun test() {
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        for ((k, v) in map) {
            println("$k -> $v")
        }
    }

    /**
     * 相等性
     * 1.三种运算符   ==, ===, equals()
     * 2.结构相等（用 equals() 检查） 由 ==（以及其否定形式 !=）操作判断
     * 3.引用相等（两个引用指向同一对象）
     */
    fun test_equality() {
        val s1 = "Doug"
        // 使用这种方式创建就是为了创建两个地址不同的字符串。
        val s2 = String(charArrayOf('D', 'o', 'u', 'g'))
        L.i(s1)//Doug
        L.i(s2)//Doug
        // 如果两个字符串的值相同那么hashCode也相等
        L.i("s1.hashCode() =${s1.hashCode()}")//2136189
        L.i("s2.hashCode() =${s2.hashCode()}")//2136189
        // == <==> equals , 比较的都是字符串的值。
        L.i("s1 == s2 ${s1 == s2}")//true
        L.i("s1.equals(s2) ${s1.equals(s2)}")//true
        // === 比较两个对象的引用是否相同。
        L.i("s1 === s2 ${s1 === s2}")//flase
    }

    /**
     *测试数据
     */
    val stringArray = arrayOf("UK", "Germany", "Italy")
    val stringArray1 = emptyArray<String>()//长度为0的空数组

}

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
//        L.i("${testAutomaticCasts("12345")}")
//        testForCycle(stringArray)
//        testWhile(stringArray)
//        testWhen(1)
//        testFor(stringArray, 2)
//        testRanges(3, 11)
//        testContains(stringArray, "UK")
//        testMap()
//        test_equality()
//        L.i("0 和 1 之间大的数字是：${testConditionalJudgment(0, 1)}")
//        L.i("parseInt的值：${parseInt("1")}")
//        testConditionalJudgment3("123456")
//        testConditionalJudgment4("1")
//        myTurtle(7, 5)
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
        L.i(x.toString())
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
    //1.if的一般写法
    fun testConditionalJudgment(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    //2.if作为表达式
    fun testConditionalJudgment2(a: Int, b: Int) = if (a > b) a else b

    //3.if not null 缩写
    fun testConditionalJudgment3(obj: Any) {
        L.i("obj 不为空字符串 长度为  ${obj?.toString().length}")
    }

    //4.if null 执行一个语句
    fun testConditionalJudgment4(a: String? = null) {
        L.i("${a ?: "a 为 null"}")
    }


    /**
     * 空值与 null 检测
     * 当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
     */
    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }


    /**
     * 运算符用于类型判断
     * is 运算符检测一个表达式是否某类型的一个实例
     */
    fun testAutomaticCasts(obj: Any): Int? {
        //`obj` 在 `&&` 右边自动转换成 `String` 类型
        if (obj is String && obj.length > 0) {
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
            L.i("args 在 $i 是 ${args[i]}")
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
     * while 循环
     */
    fun testWhile(args: Array<String>) {
        var index = 0
        while (index < args.size) {
            L.i("args 在 $index 是 ${args[index]}")
            index++
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
     * 使用 in 运算符来判断集合内是否包含某实例
     */
    fun testContains(args: Array<String>, arg: String) {
        if (arg in args) {
            println(arg + "----->在该集合内")
        } else {
            println(arg + "----->不在该集合内")
        }
    }


    /************** 习惯用法 start **************/
    /**
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
     * 一个对象实例调用多个方法 （with）
     */
    class Turtle {
        //1.加法
        fun sum(a: Int, b: Int) {
            L.i("a 和 b 之和：${a + b} ")
        }

        //2.减法
        fun subtraction(a: Int, b: Int) {
            L.i("a 和 b 之差：${a - b} ")
        }
    }

    fun myTurtle(a: Int = 0, b: Int = 0) {
        val myturtle = Turtle()
        with(myturtle) {
            if (a > b) subtraction(a, b) else sum(a, b)
        }
    }


    /************** 习惯用法 end **************/


    /**
     *测试数据
     */
    val stringArray = arrayOf("UK", "Germany", "Italy")
    val stringArray1 = emptyArray<String>()//长度为0的空数组

}

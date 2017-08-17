package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.testkotlin.R
import utils.LogUtils

/**
 *基本语法
 */
class BasicGrammarActivity : AppCompatActivity() {

    val TAG: String = "BasicGrammarActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_grammar)
        localvariables()
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
    fun localvariables() {
        val a: Int = 1
        val b = 1  // `Int` 类型自动推断
        val c: Int // 如果没有初始值，声明常量时，常量的类型不能省略
        c = 1 // 明确赋值
        LogUtils.i(a)
        LogUtils.i(b)
        LogUtils.i(c)
    }


}

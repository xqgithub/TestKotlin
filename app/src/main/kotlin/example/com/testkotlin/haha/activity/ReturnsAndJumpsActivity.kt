package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by admin on 2017/9/14.
 * 返回和跳转
 */
class ReturnsAndJumpsActivity : AppCompatActivity() {

    val TAG: String = "ReturnsAndJumpsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        testLabel()
//        testReturn(0, 20)
        testReturn1(0, 20)
    }

    fun testLabel() {
        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (j == 7) {
                    println("$TAG----->i==" + i)
                    println("$TAG----->j==" + j)
                    continue@loop
                }
            }

        }
    }

    fun testReturn(a: Int, b: Int) {
        (a..b).forEach continuing@{
            if (it >= 10) {
                return@continuing
            } else {
                println("$TAG----->it==" + it)
            }
        }
    }

    fun testReturn1(a: Int, b: Int) {
        (a..b).forEach continuing@{
            print(it)
            if (it >= 10) {
                return@continuing
            }
            println("$TAG----->it==" + it)
        }
        println("$TAG----->haha")
    }


}
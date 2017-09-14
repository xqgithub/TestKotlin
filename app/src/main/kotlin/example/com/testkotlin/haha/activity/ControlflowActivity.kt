package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.testkotlin.haha.utils.CompanionUtil

/**
 * Created by admin on 2017/9/8.
 * 控制流
 */
class ControlflowActivity : AppCompatActivity() {

    val TAG: String = "ControlflowActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        val max = testIf(1, 2)
//        CompanionUtil.toast(this, "max----->$max", 0)

//        testWhen(15)

        testFor()
    }

    fun testIf(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun testWhen(x: Any): Boolean {
        return when (x) {
            1 -> {
                CompanionUtil.toast(this, "x----->1", 0)
                true
            }
            in 10..20 -> {
                CompanionUtil.toast(this, "x is in the range", 0)
                true
            }
            is String -> true
            else -> {
                CompanionUtil.toast(this, "otherwise", 0)
                false
            }
        }
    }

    fun testFor() {
        val stringArray = arrayOf("UK", "Germany", "Italy")
        for (i in stringArray.indices) {
            println("$TAG----->" + stringArray[i])
        }


    }


}
package example.com.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.text = "我是海贼王路飞"
//        println(add(1, 2))
//        toast("我弹出来了", 1)
//        niceToast("我弹出来了")
//        println("$TAG----->" + tv_main.text)
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String, tag: String = TAG, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "$TAG---->$message", length).show()
    }
}
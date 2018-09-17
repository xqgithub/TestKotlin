package example.com.testkotlin.haha.utils

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import example.com.testkotlin.haha.app.MyApp

/**
 * Created by XQ on 2018/1/5.
 * 扩展属性和方法
 */


/**
 *吐司
 */
fun Context.toasthaha(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MyApp.context!!, message, length).show()
}

/**
 * textview 左边距离设置
 */
var TextView.leftMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).leftMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).leftMargin = value
    }





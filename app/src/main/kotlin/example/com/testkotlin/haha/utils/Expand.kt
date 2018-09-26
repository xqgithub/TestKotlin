package example.com.testkotlin.haha.utils

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by XQ on 2018/1/5.
 * 扩展属性和方法
 * 1.扩展函数数是指在一个类上增加一种新的行为，甚至我们没有这个类代码的访问权限
 * 2.在Java中，通常会实现很多带有static方法的工具类，而Kotlin中扩展函数的一个优势是我们不需要在调用方法的时候把整个对象当作参数传入，它表现得就像是属于这个类的一样，而且我们可以使用this关键字和调用所有public方法。
 * 3.扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中
 */


/**
 *吐司
 */
fun Context.toasthaha(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
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

/**
 *Kotlin 实现 ViewHolder 的扩展函数 实现和使用起来更加方便流畅，甚至都感觉不到 ViewHolder 这种特殊机制的存在
 */
fun <T : View> View.findViewOften(viewId: Int): T {
    var viewHolder: SparseArray<View> = tag as? SparseArray<View> ?: SparseArray()
    tag = viewHolder
    var childView: View? = viewHolder.get(viewId)
    if (null == childView) {
        childView = findViewById(viewId)
        viewHolder.put(viewId, childView)
    }
    return childView as T
}
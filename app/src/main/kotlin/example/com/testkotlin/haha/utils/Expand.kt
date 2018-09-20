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
 * Kotlin 标准库扩展函数集合 详情 请参考：Kotlin 扩展函数详解与应用 第四点   https://blog.csdn.net/ComWill/article/details/77206508
 * 1.apply      接受一个lambda表达式作为参数，并在apply调用时立即执行，apply返回原来的对象
 * 2.let        let 和 apply 类似， 唯一的不同是返回值，let返回的不是原来的对象，而是闭包里面的值
 * 3.with       with 是一个顶级函数， 当你想调用对象的多个方法但是不想重复对象引用
 * 4.run        run 是 with和let 的组合
 * 5.lazy       lazy延迟运算，当第一次访问时，调用相应的初始化函数
 * 6.use        use 用在 Java 上的 try-with-resources 表达式上
 * 7.reapt      顾名思义，repeat 就是重复的意思，它接受函数和整数作为参数，函数会被调用 n 次，这个函数避免写循环
 * 8.require/assert/check     用来检测条件是否为true, 否则抛出异常。 其中 require 用在参数检查； 而 assert/check 用在内部状态检查，assert 抛出 AssertionException 、 check 抛出 IllegalStateException
 */



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









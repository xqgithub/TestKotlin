package example.com.testkotlin.haha.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by admin on 2017/9/8.
 * 静态类
 */
class CompanionUtil {

    /**
     * 1.companion object 相当与 java中的static
     * 2.只能定义在对应的类中
     * 3.@JvmStatic使Companion object的成员真正成为静态成员
     */
    companion object {
        /**
         *全局吐司显示
         */
        @JvmStatic
        fun toast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, length).show()
        }
    }
}
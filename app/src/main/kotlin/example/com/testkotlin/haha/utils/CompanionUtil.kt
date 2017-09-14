package example.com.testkotlin.haha.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by admin on 2017/9/8.
 * 静态类
 */
class CompanionUtil {

    companion object {
        /**
         *全局吐司显示
         */
        fun toast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, length).show()
        }
    }


}
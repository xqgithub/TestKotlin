package example.com.testkotlin.haha.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import example.com.testkotlin.haha.app.MyApp

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

        /**
         * 等屏幕的宽度  px
         */
        fun getScreenWidth(): Int {

            val windowManager = MyApp.context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()// 创建了一张白纸
            windowManager.defaultDisplay.getMetrics(dm)// 给白纸设置宽高
            return dm.widthPixels
        }

        /**
         * 得到屏幕的高度 px
         */
        fun getScreenHeight(): Int {
            val windowManager = MyApp.context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()// 创建了一张白纸
            windowManager.defaultDisplay.getMetrics(dm)// 给白纸设置宽高
            return dm.heightPixels
        }

        /**
         * 得到设备的密度
         */
        fun getScreenDensity(context: Context): Float {
            return context.resources.displayMetrics.density
        }

        /**
         * 得到设备的densityDpi
         */
        fun getScreendensityDpi(context: Context): Int {
            return context.resources.displayMetrics.densityDpi
        }

        /**
         * 获取屏幕宽度 dp
         */
        fun getScreenWidthDP(context: Context): Int {
            return (getScreenWidth() / getScreenDensity(context)).toInt()
        }

        /**
         * 获取屏幕的高度 dp
         */
        fun getScreenHeightDP(context: Context): Int {
            return (getScreenHeight() / getScreenDensity(context)).toInt()
        }
    }


}
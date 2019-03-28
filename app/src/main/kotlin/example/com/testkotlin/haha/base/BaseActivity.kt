package example.com.testkotlin.haha.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by beijixiong on 2018/9/19.
 * Activity的基类
 */
abstract class BaseActivity : RxAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 禁止横竖屏切换
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
//        transparentStatusBar()
        onBeforeSetContentLayout()
        setContentView(getLayoutId())
        initView()
        initData()
        initListener()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    /**
     * 在设置视图内容之前
     * 需要做什么操作可以写在该方法中
     */
    fun onBeforeSetContentLayout() {

    }

    /**
     * 设置视图
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化 view
     */
    abstract fun initView()

    /**
     *初始化数据
     */
    abstract fun initData()

    /**
     * 初始化监听
     */
    abstract fun initListener()

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }


    /**
     * 状态栏透明方法
     * - SYSTEM_UI_FLAG_LOW_PROFILE   设置状态栏和导航栏中的图标变小，变模糊或者弱化其效果。这个标志一般用于游戏，电子书，视频，或者不需要去分散用户注意力的应用软件。
     * - SYSTEM_UI_FLAG_HIDE_NAVIGATION  隐藏导航栏，点击屏幕任意区域，导航栏将重新出现，并且不会自动消失
     * - SYSTEM_UI_FLAG_FULLSCREEN       隐藏状态栏，点击屏幕区域不会出现，需要从状态栏位置下拉才会出现
     * - SYSTEM_UI_FLAG_LAYOUT_STABLE    稳定布局，主要是在全屏和非全屏切换时，布局不要有大的变化。一般和View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN、View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION搭配使用。同时，android:fitsSystemWindows要设置为true
     * - SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION  将布局内容拓展到导航栏的后面
     * - SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN     将布局内容拓展到状态的后面
     * - SYSTEM_UI_FLAG_IMMERSIVE    使状态栏和导航栏真正的进入沉浸模式,即全屏模式，如果没有设置这个标志，设置全屏时，我们点击屏幕的任意位置，就会恢复为正常模式
     * - SYSTEM_UI_FLAG_IMMERSIVE_STICKY  它的效果跟View.SYSTEM_UI_FLAG_IMMERSIVE一样。但是，它在全屏模式下，用户上下拉状态栏或者导航栏时，这些系统栏只是以半透明的状态显示出来，并且在一定时间后会自动消息
     */
    fun transparentStatusBar() {
        //适配Android 4.4 +的方法
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = BaseActivity@ this.window
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            // Translucent navigation bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
        //适配 Android 5.0+ 的方法
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = BaseActivity@ this.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            window.navigationBarColor = Color.TRANSPARENT
        }
    }


}
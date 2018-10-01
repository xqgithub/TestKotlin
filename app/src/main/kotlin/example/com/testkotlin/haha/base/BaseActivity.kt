package example.com.testkotlin.haha.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
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
}
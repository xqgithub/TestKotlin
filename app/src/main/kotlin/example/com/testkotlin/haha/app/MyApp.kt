package example.com.testkotlin.haha.app

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import example.com.testkotlin.haha.http.ApiClient

/**
 * Created by XQ on 2018/1/5.
 * 我的Application
 */
class MyApp : MultiDexApplication() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        // Init Stetho
        Stetho.initializeWithDefaults(this)
        //初始化ApiClient
        ApiClient.instance.init()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        context = this
        MultiDex.install(this)
    }
}
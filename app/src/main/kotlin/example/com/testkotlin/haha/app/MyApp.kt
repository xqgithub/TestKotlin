package example.com.testkotlin.haha.app

import android.app.Application
import android.content.Context

/**
 * Created by XQ on 2018/1/5.
 * 我的Application
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: Context
    }
}
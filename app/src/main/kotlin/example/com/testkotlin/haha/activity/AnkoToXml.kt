package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import example.com.testkotlin.R
import example.com.testkotlin.haha.ui.AnkoToXmlUi
import org.jetbrains.anko.setContentView

/**
 * Created by admin on 2017/8/18.
 * 运动Anko实现UI布局
 */
class AnkoToXml : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var ui = AnkoToXmlUi()
        ui.setContentView(this)
        val tv_anko = findViewById<TextView>(R.id.tv_anko)
        tv_anko.text = "Company"
    }


}
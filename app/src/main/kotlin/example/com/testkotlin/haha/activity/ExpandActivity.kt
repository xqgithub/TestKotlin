package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.testkotlin.R
import example.com.testkotlin.haha.utils.leftMargin
import example.com.testkotlin.haha.utils.toasthaha
import kotlinx.android.synthetic.main.activity_expand.*

/**
 * Created by XQ on 2018/1/5.
 * 扩展
 * 在实际开发时，如果对一个类某一功能并不通用，只有某些特殊场景使用时，可以使用扩展函数，从而显得灵活多变
 */
class ExpandActivity : AppCompatActivity() {

    val TAG: String = "ExpandActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand)
        initView()
        toasthaha("扩展吐司")
    }

    fun initView() {
        tv_expand_leftmargin.leftMargin = 100
    }

}
package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.view.View
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import example.com.testkotlin.haha.utils.leftMargin
import example.com.testkotlin.haha.utils.showLongToastSafe
import example.com.testkotlin.haha.utils.showShortToastSafe
import example.com.testkotlin.haha.utils.toasthaha
import kotlinx.android.synthetic.main.activity_expand.*

/**
 * Created by XQ on 2018/1/5.
 * 扩展
 * 在实际开发时，如果对一个类某一功能并不通用，只有某些特殊场景使用时，可以使用扩展函数，从而显得灵活多变
 */
class ExpandActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toasthaha("扩展吐司")
    }

    override fun initView() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_expand
    }

    override fun initData() {
        tv_expand_leftmargin.leftMargin = 100
    }

    override fun initListener() {
        btn_expand_1.setOnClickListener(this)
        btn_expand_2.setOnClickListener(this)
    }

    /**
     * 点击事件
     */
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_expand_1 -> btn_expand_1()
            R.id.btn_expand_2 -> btn_expand_2()
            else -> showShortToastSafe("没有该按钮存在，谢谢!")
        }
    }

    private fun btn_expand_1() {
        showShortToastSafe("我是海贼王路飞")
    }

    private fun btn_expand_2() {
//        showLongToastSafe("我是你爸爸，你不服气吗？")
        showLongToastSafe(R.string.app_name)
    }


}
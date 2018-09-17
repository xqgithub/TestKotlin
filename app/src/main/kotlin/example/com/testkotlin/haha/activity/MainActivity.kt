package example.com.testkotlin.haha.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import example.com.testkotlin.R
import example.com.testkotlin.haha.adapter.MainListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val TAG: String = "MainActivity"

    val mActivity = MainActivity@ this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.text = "我是海贼王路飞"
//        println(add(1, 2))
//        toast("我弹出来了", 1)
//        niceToast("我弹出来了")
//        println("$TAG----->" + tv_main.text)


        button_main.setOnClickListener(this)
//        TestVariableAndAttribute.test1()

        initView()

//        L.i("屏幕宽度(像素)----->" + CompanionUtil.getScreenWidth() + ";"
//                + "屏幕高度(像素)----->" + CompanionUtil.getScreenHeight())
//        L.i("屏幕宽度(dp)----->" + CompanionUtil.getScreenWidthDP(mActivity) + ";"
//                + "屏幕高度(dp)----->" + CompanionUtil.getScreenHeightDP(mActivity))
//        L.i("屏幕密度----->" + CompanionUtil.getScreenDensity(mActivity) + ";"
//                + "屏幕密度densityDpi----->" + CompanionUtil.getScreendensityDpi(mActivity))


    }

    fun initView() {
        val rv_main = findViewById(R.id.rv_main) as RecyclerView
        rv_main.layoutManager = LinearLayoutManager(mActivity)
        rv_main.adapter = MainListAdapter(items)
    }


    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String, tag: String = TAG, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "$TAG---->$message", length).show()
    }

    /**
     * 点击事件
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_main -> jumptoBasicGrammar()
        }
    }

    /**
     *跳转到TestRecyclerview页面
     */
    fun jump() {
        val intent = Intent()
        intent.setClass(MainActivity@ this, TestRecyclerview::class.java)//获取intent对象
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)// 获取class是使用::反射
        toast("已经跳转到TestRecyclerview页面", 0)
    }

    fun jumptoBasicGrammar() {
        val intent = Intent()
        intent.setClass(MainActivity@ this, BasicGrammarActivity::class.java)//获取intent对象
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)// 获取class是使用::反射
    }

    fun jumptoAnkoToXml() {
        val intent = Intent()
        intent.setClass(MainActivity@ this, AnkoToXml::class.java)//获取intent对象
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)// 获取class是使用::反射
    }


    /**
     *测试数据
     */
    public val items = listOf<String>(
            "jump to BasicGrammar",
            "jump to TestRecyclerview",
            "jump to AnkoToXml",
            "jump to Controlflow",
            "jump to ReturnsAndJumps",
            "jump to ClassInherit",
            "jump to Expand",
            "jump to DataClass",
            "jump to Generic",
            "jump to Iterable"
    )
}
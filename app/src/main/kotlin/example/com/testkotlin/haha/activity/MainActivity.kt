package example.com.testkotlin.haha.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.adapter.MainListAdapter
import example.com.testkotlin.haha.utils.*
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

        L.i("屏幕宽度(像素)----->" + getScreenWidth() + ";"
                + "屏幕高度(像素)----->" + getScreenHeight())
        L.i("屏幕宽度(dp)----->" + getScreenWidthDP(mActivity) + ";"
                + "屏幕高度(dp)----->" + getScreenHeightDP(mActivity))
        L.i("屏幕密度----->" + getScreenDensity(mActivity) + ";"
                + "屏幕密度densityDpi----->" + getScreendensityDpi(mActivity))


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
    val items = listOf<String>(
//            "jump to BasicGrammar -> 基本语法",
//            "jump to TestRecyclerview -> Recyclerview测试",
//            "jump to AnkoToXml -> 运动Anko实现UI布局",
//            "jump to Controlflow -> 控制流",
//            "jump to ReturnsAndJumps -> 返回和跳转",
//            "jump to ClassInherit -> 类和继承",
//            "jump to Expand -> 扩展",
//            "jump to DataClass -> 数据类",
//            "jump to Generic -> 泛型",
//            "jump to Iterable -> 集合归纳",
//            "jump to AttributesFields -> 属性和字段",
//            "jump to ObjectAndCompanionObject -> object和companion object关键字",
//            "jump to Entrust -> 委托和委托属性",
//            "jump to Function -> 函数",
//            "jump to InlineFunction -> 内联函数",
//            "jump to Coroutines -> 协程",
//            "jump to Deconstruction -> 解构声明"
    )
}
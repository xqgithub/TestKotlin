package example.com.testkotlin.haha.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import example.com.testkotlin.R
import example.com.testkotlin.haha.activity.*
import example.com.testkotlin.haha.utils.findViewOften

/**
 * Created by admin on 2017/9/7.
 */
class MainListAdapter(val items: List<String>) : RecyclerView.Adapter<MainListAdapter.MyViewHolder>() {


    val TAG: String = "MainListAdapter"

    var mcontext: Context? = null

    override fun getItemCount(): Int = itemsdata.size


    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //        val tv_adapter_item: TextView = view.findViewById(R.id.tv_adapter_item) as TextView
//        val tv_adapter_item: TextView = view.tv_adapter_item
        fun <T : View> findView(viewId: Int): T {
            return view.findViewOften(viewId)
        }

        val tv_adapter_item: TextView = findView(R.id.tv_adapter_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_main_list, parent, false)
        mcontext = parent.context
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_adapter_item.text = itemsdata[position]
        holder.tv_adapter_item.setOnClickListener {
            //            println("$TAG----->" + holder.view.tv_adapter_item.text)
            if (position == 0) {
                jumpToActivity(BasicGrammarActivity::class.java)
            } else if (position == 1) {
                jumpToActivity(TestRecyclerview::class.java)
            } else if (position == 2) {
                jumpToActivity(AnkoToXml::class.java)
            } else if (position == 3) {
                jumpToActivity(ControlflowActivity::class.java)
            } else if (position == 4) {
                jumpToActivity(ReturnsAndJumpsActivity::class.java)
            } else if (position == 5) {
                jumpToActivity(ClassInheritActivity::class.java)
            } else if (position == 6) {
                jumpToActivity(ExpandActivity::class.java)
            } else if (position == 7) {
                jumpToActivity(DataClassActivity::class.java)
            } else if (position == 8) {
                jumpToActivity(GenericActivity::class.java)
            } else if (position == 9) {
                jumpToActivity(IterableActivity::class.java)
            } else if (position == 10) {
                jumpToActivity(AttributesFieldsActivity::class.java)
            } else if (position == 11) {
                jumpToActivity(ObjectAndCompanionObjectActivity::class.java)
            } else if (position == 12) {
                jumpToActivity(EntrustActivity::class.java)
            } else if (position == 13) {
                jumpToActivity(FunctionActivity::class.java)
            } else if (position == 14) {
                jumpToActivity(InlineFunctionActivity::class.java)
            } else if (position == 15) {
                jumpToActivity(CoroutinesActivity::class.java)
            } else if (position == 16) {
                jumpToActivity(DeconstructionActivity::class.java)
            } else if (position == 17) {
                jumpToActivity(EmptySafetyActivity::class.java)
            } else if (position == 18) {
                jumpToActivity(JavaFromKotlinActivity::class.java)
            } else if (position == 19) {
                jumpToActivity(KotlinFromJavaActivity::class.java)
            } else if (position == 20) {
                jumpToActivity(Retrofit2Rxjava2Activity::class.java)
            } else if (position == 21) {
                jumpToActivity(SqliteActivity::class.java)
            } else if (position == 22) {
                jumpToActivity(AnkoToCommons::class.java)
            } else if (position == 23) {
                jumpToActivity(AnkoToLayout::class.java)
            }
        }
    }

    /**
     * Activity的跳转
     */
    fun jumpToActivity(clazz: Class<*>) {
        val intent = Intent()
        intent.setClass(mcontext, clazz)//获取intent对象
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        mcontext?.startActivity(intent)// 获取class是使用::反射
    }


    /**
     *测试数据
     */
    public val itemsdata = listOf(
            "jump to BasicGrammar -> 基本语法",
            "jump to TestRecyclerview -> Recyclerview测试",
            "jump to AnkoToXml -> 运动Anko实现UI布局",
            "jump to Controlflow -> 控制流",
            "jump to ReturnsAndJumps -> 返回和跳转",
            "jump to ClassInherit -> 类和继承",
            "jump to Expand -> 扩展",
            "jump to DataClass -> 数据类",
            "jump to Generic -> 泛型",
            "jump to Iterable -> 集合归纳",
            "jump to AttributesFields -> 属性和字段",
            "jump to ObjectAndCompanionObject -> object和companion object关键字",
            "jump to Entrust -> 委托和委托属性",
            "jump to Function -> 函数",
            "jump to InlineFunction -> 内联函数",
            "jump to Coroutines -> 协程",
            "jump to Deconstruction -> 解构声明",
            "jump to EmptySafety -> 空安全",
            "jump to JavaFromKotlin -> kotlin中调用java代码",
            "jump to KotlinFromJava -> java中调用kotlin代码",
            "jump to Retrofit2Rxjava2Activity -> 测试Retrofit2Rxjava2框架",
            "jump to SqliteActivity -> Sqlite测试",
            "jump to AnkoToCommons -> Anko commons库介绍",
            "jump to AnkoToLayout -> Anko layout库介绍"
    )


}
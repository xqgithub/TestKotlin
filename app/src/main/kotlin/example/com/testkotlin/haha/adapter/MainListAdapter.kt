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

    override fun getItemCount(): Int = items.size


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
        holder.tv_adapter_item.text = items[position]
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


}
package example.com.testkotlin.haha.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import example.com.testkotlin.R
import example.com.testkotlin.haha.activity.*
import kotlinx.android.synthetic.main.adapter_item_main_list.view.*

/**
 * Created by admin on 2017/9/7.
 */
class MainListAdapter(val items: List<String>) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {


    val TAG: String = "MainListAdapter"

    var mcontext: Context? = null

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.tv_adapter_item.text = items[position]
        holder.view.tv_adapter_item.setOnClickListener {
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
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_main_list, parent, false)
        mcontext = parent.context
        return ViewHolder(view)
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    fun jumpToActivity(clazz: Class<*>) {
        val intent = Intent()
        intent.setClass(mcontext, clazz)//获取intent对象
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        mcontext?.startActivity(intent)// 获取class是使用::反射
    }


}
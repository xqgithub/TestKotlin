package example.com.testkotlin.haha.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import example.com.testkotlin.R
import example.com.testkotlin.haha.activity.AnkoToXml
import example.com.testkotlin.haha.activity.BasicGrammarActivity
import example.com.testkotlin.haha.activity.ControlflowActivity
import example.com.testkotlin.haha.activity.TestRecyclerview
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
                val intent = Intent()
                intent.setClass(mcontext, BasicGrammarActivity::class.java)//获取intent对象
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                mcontext?.startActivity(intent)// 获取class是使用::反射
            } else if (position == 1) {
                val intent = Intent()
                intent.setClass(mcontext, TestRecyclerview::class.java)//获取intent对象
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                mcontext?.startActivity(intent)// 获取class是使用::反射
            } else if (position == 2) {
                val intent = Intent()
                intent.setClass(mcontext, AnkoToXml::class.java)//获取intent对象
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                mcontext?.startActivity(intent)// 获取class是使用::反射
            } else if (position == 3) {
                val intent = Intent()
                intent.setClass(mcontext, ControlflowActivity::class.java)//获取intent对象
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                mcontext?.startActivity(intent)// 获取class是使用::反射
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
}
package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import example.com.testkotlin.haha.db.*
import example.com.testkotlin.haha.utils.showLongToastSafe
import kotlinx.android.synthetic.main.activity_sqlite.*

/**
 * Created by beijixiong on 2018/10/3.
 */
class SqliteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val company = Company()

        btn_sqlite_single.setOnClickListener {
            //            val companyData = CompanyData()
//            companyData.name = "路飞"
//            companyData.address = "武汉"
//            companyData.code = 71
//            if (company.insertSingleData(this, CompanyTable.TABLE_NAME, companyData) != -1L) {
//                showLongToastSafe("插入单条数据成功")
//            } else {
//                showLongToastSafe("插入单条数据失败")
//            }
            val response = UserhttpheadResponse()
            response.uid = 1
            response.unm = "haha"
            response.uip = "xixi"
            response.locbean = UserhttpheadResponse.LocBean()
            response.locbean?.type = "ok"
            var doublelist = mutableListOf<Double>()
            doublelist.add(0.01)
            doublelist.add(0.02)
            response.locbean?.coordinates = doublelist
            val operate = UserhttpheadOperate()
            operate.insertSingleData(this, UserhttpheadTable.TABLE_NAME, response)
        }
        btn_sqlite_multiple.setOnClickListener {

            val companyData = CompanyData()
            companyData.name = "路飞"
            companyData.address = "武汉"
            companyData.code = 71
            val companyData1 = CompanyData()
            companyData1.name = "娜美"
            companyData1.address = "上海"
            companyData1.code = 72
            val companyData2 = CompanyData()
            companyData2.name = "索隆"
            companyData2.address = "北京"
            companyData2.code = 73
            val list = mutableListOf<CompanyData>()
            list.add(companyData)
            list.add(companyData1)
            list.add(companyData2)
            if (company.insertMultipleData(this, CompanyTable.TABLE_NAME, list) != -1L) {
                showLongToastSafe("插入多条数据成功")
            } else {
                showLongToastSafe("插入多条数据失败")
            }
        }

        btn_sqlite_clear.setOnClickListener {
            company.clearAllData(this, CompanyTable.TABLE_NAME)
        }

        btn_sqlite_delete.setOnClickListener {
            if (company.deleteDataFromOneField(this, CompanyTable.TABLE_NAME, CompanyTable.NAME, "路飞") != -1) {
                showLongToastSafe("删除数据成功")
            } else {
                showLongToastSafe("删除数据失败")
            }
        }

        btn_sqlite_selectall.setOnClickListener {
            //            val list = company.selectAllData(this, CompanyTable.TABLE_NAME)
//            val contacts: MutableList<CompanyData> = ArrayList(list)//List数据移植到MutableList中
//            contacts.removeAt(0)
//            if (list.isNotEmpty()) {
//                for (args in list) {
//                    val code = args.code
//                    L.i("$code")
//                }
//            }
//            L.i("$contacts")
            val operate = UserhttpheadOperate()
            val mutablelist = operate.selectAllData(this, UserhttpheadTable.TABLE_NAME)
            if (mutablelist.isNotEmpty()) {
                for (args in mutablelist) {
                    L.i("uid=${args.uid}")
                }
            }
        }
        btn_sqlite_selectone.setOnClickListener {
            val companytemp = company.selectOneRowData(this, CompanyTable.TABLE_NAME, CompanyTable.NAME, "索隆")
            L.i("${companytemp?.name}")
        }

        btn_sqlite_update.setOnClickListener {
            company.updateData(this, CompanyTable.TABLE_NAME,
                    CompanyTable.NAME, "乔巴", CompanyTable.ID, "1")
        }


    }

    override fun getLayoutId(): Int {
        return R.layout.activity_sqlite
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}
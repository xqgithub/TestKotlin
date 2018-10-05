package example.com.testkotlin.haha.db

import android.content.ContentValues
import android.content.Context
import example.com.testkotlin.haha.utils.showLongToastSafe
import org.jetbrains.anko.attempt
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by beijixiong on 2018/10/4.
 *
 */
class Company : SqliteBaseOperate<CompanyData>() {


    override fun insertSingleData(context: Context, tableName: String, t: CompanyData): Long {
        var num = -1L
        context.database.use {
            if (attempt {
                        num = insert(tableName,
                                *t.map.toVarargArray()
                        )
                    }.isError) {
                num = -1L
            }
        }
        return num
    }

    override fun insertMultipleData(context: Context, tableName: String, list: MutableList<CompanyData>): Long {
        var num = -1L
        if (attempt {
                    context.database.use {
                        for (args in list) {
                            num = insert(tableName,
                                    *args.map.toVarargArray()
                            )
                        }
                    }
                }.isError) {
            num = -1L
        }
        return num
    }

    override fun selectAllData(context: Context, tableName: String): List<CompanyData> {
        var list: List<CompanyData> = arrayListOf()
        if (attempt {
                    context.database.use {
                        list = select(tableName).parseList { CompanyData(HashMap(it)) }
                    }
                }.isError) {
            context.showLongToastSafe("查询数据失败")
        }
        return list
    }

    override fun selectOneRowData(context: Context, tableName: String, fieldName: String, fieldValue: String): CompanyData? {
        var company: CompanyData? = null
        if (attempt {
                    context.database.use {
                        company = select(tableName).whereSimple("$fieldName=?", "$fieldValue")
                                .parseOpt(classParser<CompanyData>())
                    }
                }.isError) {
            context.showLongToastSafe("查询数据失败")
        }
        return company
    }


    override fun updateData(context: Context, tableName: String, fieldName: String, fieldValue: String, whereName: String, whereValues: String) {
        if (attempt {
                    context.database.use {
                        val contentvalues = ContentValues()
                        contentvalues.put("$fieldName", "$fieldValue")
                        val result = update("$tableName", contentvalues, "$whereName = ?", arrayOf(whereValues))
                        if (result != 0) context.showLongToastSafe("修改数据成功") else context.showLongToastSafe("修改数据失败")
                    }
                }.isError) {
            context.showLongToastSafe("修改数据出错")
        }
    }

    override fun deleteDataFromOneField(context: Context, tableName: String, fieldName: String, fieldValue: String): Int {
        var num = -1
        if (attempt {
                    context.database.use {
                        num = delete(tableName, "$fieldName = {name}", "name" to "$fieldValue")
                    }
                }.isError) {
            num = -1
        }
        return num
    }

    override fun clearAllData(context: Context, tableName: String): String {
        var message = ""
        if (attempt {
                    context.database.use {
                        execSQL("delete from $tableName")
                    }
                    message = "执行操作成功"
                }.isError) {
            message = "执行操作失败"
        }
        return message
    }


}
package example.com.testkotlin.haha.db

import android.content.Context
import example.com.testkotlin.haha.utils.showLongToastSafe
import org.jetbrains.anko.attempt
import org.jetbrains.anko.db.insert

/**
 * Created by beijixiong on 2018/10/9.
 */
class UserhttpheadOperate {

    fun insertSingleData(context: Context, tableName: String, t: UserhttpheadResponse): Long {
        var num = -1L
        context.database.use {
            if (attempt {
                        num = insert(tableName,
                                UserhttpheadTable.UID to t.uid,
                                UserhttpheadTable.UNM to t.unm,
                                UserhttpheadTable.UIP to t.uip,
                                UserhttpheadTable.TYPE to t.locbean?.type,
                                UserhttpheadTable.X to t.locbean?.coordinates!![0].toString(),
                                UserhttpheadTable.Y to t.locbean?.coordinates!![1].toString()
                        )
                    }.isError) {
                num = -1L
            }
        }
        return num
    }


    fun selectAllData(context: Context, tableName: String): MutableList<UserhttpheadResponse> {
        var listuserhttpheadresponse = mutableListOf<UserhttpheadResponse>()
        if (attempt {
                    context.database.use {
                        val cursor = query("$tableName",
                                arrayOf(UserhttpheadTable.UID,
                                        UserhttpheadTable.UNM,
                                        UserhttpheadTable.UIP,
                                        UserhttpheadTable.TYPE,
                                        UserhttpheadTable.X,
                                        UserhttpheadTable.Y
                                ), null, null, null, null, null)
                        while (cursor.moveToNext()) {
                            val uid = cursor.getInt(cursor.getColumnIndex(UserhttpheadTable.UID))
                            val unm = cursor.getString(cursor.getColumnIndex(UserhttpheadTable.UNM))
                            val uip = cursor.getString(cursor.getColumnIndex(UserhttpheadTable.UIP))
                            val type = cursor.getString(cursor.getColumnIndex(UserhttpheadTable.TYPE))
                            val x = cursor.getDouble(cursor.getColumnIndex(UserhttpheadTable.X))
                            val y = cursor.getDouble(cursor.getColumnIndex(UserhttpheadTable.Y))
                            val listlocbean = mutableListOf<Double>()
                            listlocbean.add(x)
                            listlocbean.add(y)
                            val locbean = UserhttpheadResponse.LocBean(listlocbean, type)
                            listuserhttpheadresponse.add(UserhttpheadResponse(uid, unm, uip, locbean))
                        }
                    }
                }.isError) {
            context.showLongToastSafe("查询数据失败")
        }
        return listuserhttpheadresponse
    }
}
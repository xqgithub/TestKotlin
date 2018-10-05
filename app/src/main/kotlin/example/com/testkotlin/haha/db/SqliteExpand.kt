package example.com.testkotlin.haha.db

import android.content.Context
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Created by beijixiong on 2018/10/3.
 */

/**
 * 数据库操作的扩展
 */
val Context.database: DatabaseHelper
    get() = DatabaseHelper.Instance(applicationContext)

/**
 * MutableMap 的扩展函数,数据库插入的时候调用
 */
fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()


/**
 * 多条数据解析
 */
fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

/**
 * 单条数据解析
 */
fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
        parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })










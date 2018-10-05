package example.com.testkotlin.haha.db

import android.content.Context

/**
 * Created by beijixiong on 2018/10/4.
 * sqlite操作基础类
 */
abstract class SqliteBaseOperate<T> {
    /**
     * 插入单条数据
     */
    abstract fun insertSingleData(context: Context, tableName: String, t: T): Long

    /**
     * 插入多条数据
     */
    abstract fun insertMultipleData(context: Context, tableName: String, list: MutableList<T>): Long


    /**
     * 查询全部数据
     * 查询多行，使用parseList(rowParser)来解析
     */
    abstract fun selectAllData(context: Context, tableName: String): List<T>

    /**
     * 查询单条数据
     * 1.查询一行数据，使用parseSingle(rowParser)来返回
     * 2.查询最多一行数据，使用parseOpt(rowParser)来返回结果
     */
    abstract fun selectOneRowData(context: Context, tableName: String, fieldName: String, fieldValue: String): T?


    /**
     * 修改数据
     */
    abstract fun updateData(context: Context, tableName: String, fieldName: String, fieldValue: String, whereName: String, whereValues: String)


    /**
     * 根据某一个字段来删除数据
     */
    abstract fun deleteDataFromOneField(context: Context, tableName: String, fieldName: String, fieldValue: String): Int

    /**
     * 清空表中的所有数据
     */
    abstract fun clearAllData(context: Context, tableName: String): String


}
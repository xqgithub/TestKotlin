package example.com.testkotlin.haha.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by beijixiong on 2018/10/3.
 */
class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {

    companion object {
        private var instance: DatabaseHelper? = null
        @Synchronized
        fun Instance(context: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(context.applicationContext)
            }
            return instance!!
        }

        val DB_NAME = "testkotlin"
        val DB_VERSION = 1
    }

    /**
     *创建数据表
     */
    override fun onCreate(database: SQLiteDatabase) {
        database.createTable(CompanyTable.TABLE_NAME, true,
                CompanyTable.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                CompanyTable.NAME to TEXT,
                CompanyTable.ADDRESS to TEXT,
                CompanyTable.CODE to INTEGER
        )
    }

    /**
     * 数据库升级
     */
    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        database.dropTable(CompanyTable.TABLE_NAME, true)
        onCreate(database)
    }
}
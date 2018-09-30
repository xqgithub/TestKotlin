package example.com.testkotlin.haha.http

/**
 * Created by beijixiong on 2018/9/30.
 * 定义了一个错误消息的的实体类ApiErrorModel(在Kotlin中即为一个数据类)，用于包含错误信息提示用户或服务器返回的错误信息以提示开发人员
 */
data class ApiErrorModel(var status: Int, var message: String)
package example.com.testkotlin.haha.http

import android.content.Context
import android.support.annotation.StringRes
import example.com.testkotlin.R

/**
 * Created by beijixiong on 2018/9/30.
 * 定义了一个枚举类ApiErrorType，用于列举出服务器定义的错误状态码
 */
enum class ApiErrorType(val code: Int, @param: StringRes private val messageId: Int) {

    INTERNAL_SERVER_ERROR(500, R.string.service_error),
    BAD_GATEWAY(502, R.string.service_error),
    NOT_FOUND(404, R.string.not_found),
    CONNECTION_TIMEOUT(408, R.string.timeout),
    NETWORK_NOT_CONNECT(499, R.string.network_wrong),
    UNEXPECTED_ERROR(700, R.string.unexpected_error);

    private val DEFAULT_CODE = 1

    fun getApiErrorModel(context: Context): ApiErrorModel {
        return ApiErrorModel(DEFAULT_CODE, context.getString(messageId))
    }
}
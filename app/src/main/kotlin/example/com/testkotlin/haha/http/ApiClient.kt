package example.com.testkotlin.haha.http

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Created by beijixiong on 2018/9/30.
 * 为了方便每一个API的调用操作，创建了一个单例类ApiClient
 */
class ApiClient private constructor() {

    lateinit var service: ApiService

    private object Holder {
        val INSTANCE = ApiClient()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    fun init() {
//        val okHttpClient = OkHttpClient().newBuilder()
//                .addInterceptor(HttpLoggingInterceptor().setLevel(
//                        if (true) HttpLoggingInterceptor.Level.BODY
//                        else HttpLoggingInterceptor.Level.NONE
//                ))
//                .build()
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okHttpClient)
//                .build()
//
//        service = retrofit.create(ApiService::class.java)
//----------------------------------------------以上是简单的例子测试--------------------------------------------------
        initHttpClientBuilder()
    }

    val isDebug = true
    private var httpClientBuilder: OkHttpClient.Builder? = null
    private var sClient: OkHttpClient? = null
    private var DEFAULT_CONNECT_TIME_OUT = 10L // 超时时间 10s
    private var DEFAULT_READ_TIME_OUT = 10L
    private fun initHttpClientBuilder() {
        httpClientBuilder = OkHttpClient.Builder().apply {
            writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//写操作 超时时间
            connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.SECONDS)//连接超时时间
            readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//读操作超时时间
        }.apply {
            if (isDebug) {
//                val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
//                    if (message.startsWith("<--") || message.startsWith("{")) {
//                        L.i(message)
//                    }
//                }).apply {
//                    level = HttpLoggingInterceptor.Level.BODY
//                }
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                addNetworkInterceptor(StethoInterceptor())
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(lgnoreHttps())
                .build()
        return retrofit
    }

    public fun getApiService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }

    /**
     * 忽略https验证
     */
    fun lgnoreHttps(): OkHttpClient? {
        sClient = httpClientBuilder?.build()
        var sc: SSLContext? = null
        try {
            sc = SSLContext.getInstance("SSL")
            sc!!.init(null, arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(java.security.cert.CertificateException::class)
                override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {

                }

                @Throws(java.security.cert.CertificateException::class)
                override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {

                }

                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? {
                    return null
                }
            }), SecureRandom())
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val hv1 = HostnameVerifier { hostname, session -> true }

        val workerClassName = "okhttp3.OkHttpClient"

        try {
            val workerClass = Class.forName(workerClassName)
            val hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier")
            hostnameVerifier.isAccessible = true
            hostnameVerifier.set(sClient, hv1)

            val sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory")
            sslSocketFactory.isAccessible = true
            sslSocketFactory.set(sClient, sc!!.socketFactory)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sClient
    }


}
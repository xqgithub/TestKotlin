package example.com.testkotlin.haha.domaininterface

import com.safframework.log.L

/**
 * Created by XQ on 2018/1/5.
 * 继承的父接口
 */
interface BaseInterface {


    fun allowRewrite() {
        val TAG: String = "BaseInterface"
        L.i("$TAG----->我是父接口allowRewrite")
    }

    fun b() {
        val TAG: String = "BaseInterface"
        L.i("$TAG----->我是父接口b")
    }
}
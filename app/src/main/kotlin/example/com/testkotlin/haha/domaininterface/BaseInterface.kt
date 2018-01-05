package example.com.testkotlin.haha.domaininterface

/**
 * Created by XQ on 2018/1/5.
 * 继承的父接口
 */
interface BaseInterface {


    fun allowRewrite() {
        val TAG: String = "BaseInterface"
        println("$TAG----->我是父接口allowRewrite")
    }

    fun b() {
        val TAG: String = "BaseInterface"
        println("$TAG----->我是父接口b")
    }
}
package example.com.testkotlin.haha.domain

/**
 * Created by XQ on 2018/1/5.
 * 继承的父类
 */
open class Base {//要求父类必须有open标注，不然无法被子类所继承

    val TAG: String = "Base"

    /**
     *被覆盖的函数必须有open标注，不然无法被重写
     */
    open fun allowRewrite() {
        println("$TAG----->我是父类，允许被重写的方法")
    }

    fun unAllowRewrite() {
        println("$TAG----->我是父类，不允许被重写的方法")
    }
}



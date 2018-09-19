package example.com.testkotlin.haha.domain

import com.safframework.log.L

/**
 * Created by XQ on 2018/1/5.
 * 继承的父类
 */
open class Base() {//要求父类必须有open标注，不然无法被子类所继承

    val TAG: String = "Base"

    open val base_a: Int = 1
    open val base_b: Int = 2

    /**
     * Base类的加载块
     * 设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员
     */
    init {
        L.i("Initializing Base")
    }
    /**
     *被覆盖的函数必须有open标注，不然无法被重写
     */
    open fun allowRewrite() {
        L.i("$TAG----->我是父类，允许被重写的方法allowRewrite")
    }

    fun unAllowRewrite() {
        L.i("$TAG----->我是父类，不允许被重写的方法unAllowRewrite")
    }


}



package example.com.testkotlin.haha.domain

import com.safframework.log.L

/**
 * Created by XQ on 2017/9/15.
 * 属性和字段
 */
class Person(val name: String) {

    val TAG: String = "Person"

    //init加载模块在次构造函数constructor之前
    init {
        L.i("$TAG--我是构造参数--->" + name.toUpperCase())
    }

    /**
     * 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。
     * 委托到同一个类的另一个构造函数用 this 关键字即可
     */
    constructor(name: String, age: Int) : this(name) {
        L.i("名字是 $name 年龄是 $age")
    }


    var lastName: String = "zhouxingxing"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

}
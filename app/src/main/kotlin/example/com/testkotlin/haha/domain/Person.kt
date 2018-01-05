package example.com.testkotlin.haha.domain

/**
 * Created by admin on 2017/9/15.
 */
class Person(name: String) {

    val TAG: String = "Person"

    init {
        println("$TAG--我是构造参数--->" + name.toUpperCase())
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
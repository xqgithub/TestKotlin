package example.com.testkotlin.haha.domain

import com.safframework.log.L

/**
 * Created by XQ on 2018/1/5.
 * 继承的子类
 */

class Inherited(name: String, lastName: String) : Base(){

    val TAGG: String = "inheritedclass"

    /**
     * 1.属性覆盖与方法覆盖类似；在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。
     * 2.每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖。
     */
    override val base_a: Int
        get() = 11

    /**
     * 1.你也可以用一个 var 属性覆盖一个 val 属性，但反之则不行。
     * 2.这是允许的，因为一个 val 属性本质上声明了一个 getter 方法，而将其覆盖为 var 只是在子类中额外声明一个 setter 方法。
     */
    override var base_b: Int = 0
        get() = field
        set(value) {
            if (value > 1) field = 22 else field = -1
        }

    /**
     * Inherited的加载块
     *
     */
    init {
        L.i("Initializing Inherited")
    }

    /**
     *1.函数上必须加上override标注,才有能重写
     *2.子类不允许和父类有重名的函数名，如果父类没有加open
     *3.super<X>来消除歧义,表示是调用的是父类方法
     *4.标记为override 的成员本身是开放的，也就是说，它可以在子类中覆盖。如果你想禁止再次覆盖，使用 final 关键字
     */
    override fun allowRewrite() {
//        super<Base>.allowRewrite()//父类 的方法
//        super<BaseInterface>.allowRewrite()//父接口 的方法
//        L.i("$TAGG----->我是子类,允许被重写了的方法allowRewrite")
        L.i("$TAGG----->base_a 的值是 $base_a")

        base_b = 3
        L.i("$TAGG----->base_b 的值是 $base_b")
    }

    /**
     * 内部类
     * 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
     */
    inner class Baz {
        fun g() {
            super@Inherited.allowRewrite() // 调用 Base 实现的 allowRewrite()
        }
    }
}
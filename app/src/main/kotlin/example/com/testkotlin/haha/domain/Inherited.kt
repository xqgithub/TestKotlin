package example.com.testkotlin.haha.domain

import example.com.testkotlin.haha.domaininterface.BaseInterface

/**
 * Created by XQ on 2018/1/5.
 * 继承的子类
 */

class Inherited() : Base(), BaseInterface {

    val TAGG: String = "inheritedclass"

    /**
     *函数上必须加上override标注,才有能重写
     *子类不允许和父类有重名的函数名，如果父类没有加open
     *
     * super<X>来消除歧义
     */
    override fun allowRewrite() {
//        super<Base>.allowRewrite()//父类的方法
//        super<BaseInterface>.allowRewrite()//父接口的方法
        println("$TAGG----->我是子类,允许被重写了")
    }
}
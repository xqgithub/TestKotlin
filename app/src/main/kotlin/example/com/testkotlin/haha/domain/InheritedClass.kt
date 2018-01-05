package example.com.testkotlin.haha.domain

/**
 * Created by XQ on 2018/1/5.
 * 继承的子类
 */

class Inheritedclass : Base() {

    val TAGG: String = "Inheritedclass"

    /**
     *函数上必须加上override标注,才有能重写
     *子类不允许和父类有重名的函数名，如果父类没有加open
     */
    override fun allowRewrite() {
//        super.allowRewrite()//父类的方法
        println("$TAGG----->我是子类,允许被重写了")
    }
}


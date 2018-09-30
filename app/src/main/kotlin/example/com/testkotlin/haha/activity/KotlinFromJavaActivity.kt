package example.com.testkotlin.haha.activity

import android.os.Bundle
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity
import java.io.IOException

/**
 * Created by beijixiong on 2018/9/28.
 * Java 调用 Kotlin
 */
class KotlinFromJavaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_kotlinfromjava
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    /**
     * kotlin属性(Properties)
     * 1.getter方法,名称是在kotlin属性名前加get并且属性名首字母大写;
     * 2.setter方法(只适用于var属性),名称是在kotlin属性名前加set并且属性名首字母大写;
     * 3.private私有字段,名称与kotlin属性同名(只适用于具有幕后字段[backing field]的属性)
     */

    /**
     * kotlin包级函数
     * 1.在demo包内的example.kt文件中声明的所有函数和属性(包括扩展函数),都被编译成一个名为demo.ExampleKt的Java类的静态方法
     * 2.可以使用@JvmName注解修改生成的Java类名
     * 3.如果多个不同文件的包名相同且@JvmName注解相同,可用@JvmMultifileClass注解,编译器能够生成一个单一Java外观类
     */

    /**
     * 静态字段(Static Fields)
     * 1.@JvmField 注解    用@JvmField注解属性,使对应的java静态字段与kotlin属性可见性相同(默认public)
     * 2.lateinit 修饰符   用lateinit修饰属性,使对应的静态字段与属性访问器setter可见性相同(默认public)
     * 3.const 修饰符      用const修饰的(在类中以及在顶层)属性,在Java中会成为public静态字段
     *
     * 静态方法(Static Methods)
     * 1.在对象(object)或伴生对象(companion object)中的函数被@JvmStatic注解,那么编译器既会在该对象的类中生成静态方法,也会在对象自身中生成实例方法!
     * 2.此外,@JvmStatic注解也可用于对象或伴生对象的属性,使其getter和setter方法是静态成员!
     */
    companion object {
        @JvmField
        val testa: Int = 3

        lateinit var testb: DataClassActivity.Person // lateinit 延迟初始化

        const val testc = 7


        @JvmStatic
        fun foo() {
        }

        fun bar() {}
    }

    /**
     * 可见性(Visibility)
     * 1.private成员编译成Java的private成员;
     * 2.private顶层声明编译成Java的包级局部声明(package-local)；
     * 3.protected编译成Java的protected(Java允许访问同包中其它类的protected成员,所以Java类会访问权限更广);
     * 4.internal声明编译成Java的public;
     * 5.public编译成Java的public;
     */

    /**
     * KClass
     * 有时在java中调用Kotlin函数(有KClass类型参数),但无法把Java的Class自动转换成kotlin的KClass,所以必须通过调用Class<T>.kotlin扩展属性来手动转换
     * kotlin.jvm.JvmClassMappingKt.getKotlinClass(MainView.class)
     */

    /**
     * @JvmName解决java方法签名相同
     * 1.在Kotlin中用相同名称,需要用@JvmName标注其中的一个(或两个),并指定不同名称
     * 2.在Kotlin中,可以用相同名称filterValid()访问
     * 3.在Java中,需要分别用filterValid()和filterValidInt()访问
     */
    fun List<String>.test_KotlinFromJava2() {

    }

    @JvmName("filterValidInt")
    fun List<Int>.test_KotlinFromJava2() {

    }

    /**
     * Java方法重载
     * 1.如果Kotlin函数的参数有默认值并且使用@JvmOverloads注解,那么在Java中多个重载方法
     * 2.该注解也适用于构造函数和静态方法, 但不能用于抽象方法(包括接口的方法)
     * 3.对于次构造函数(Secondary Constructors), 如果所有参数都有默认值,那么会生成一个公有public的无参构造函数(没有@JvmOverloads注解也会生效)!
     */
    @JvmOverloads
    fun test_KotlinFromJava3(a: String, b: Int = 0, c: String = "abc") {
    }

    /**
     * 受检异常
     * 使用@Throws注解(相当于在Java中声明throws IOException)
     */
    // kotlin
    @Throws(IOException::class)
    fun test_KotlinFromJava4() {
        throw IOException()
    }

    /**
     * 型变泛型
     * 1.在默认没有通配符处要求java泛型通配符, 可以使用@JvmWildcard注解
     * 2.如果不需要泛型通配符,可以使用@JvmSuppressWildcards注解
     */

    /**
     * Nothing类型翻译
     * 1.类型Nothing是Kotlin特有的,在Java中没有对应类型
     * 2.Nothing类型不能在Java世界中准确表示,所以Nothing类型在java中会消失(原始类型raw type)
     */


}
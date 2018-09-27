package example.com.testkotlin.haha.activity

import android.os.Bundle
import com.safframework.log.L
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/27.
 * 解构声明
 * 将一个对象解构(destructure)为多个变量，也就是意味着一个解构声明会一次性创建多个变量
 */
class DeconstructionActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        test_deconstruction1()
        test_deconstruction2()
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_deconstruction
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }


    data class Person(var name: String, var age: Int, var addr: String) {
        var mobile: String? = null

        operator fun component4(): String {
            return this.mobile!!
        }
    }

    /**
     * 1.声明了多个变量
     * 2.将对象的属性值赋值给相应的变量
     * 3.对于普通类的成员属性，编译器并不会自动推断产生componentN() ，此时componentN()，需要我们自己定义了
     *   a.componentN()函数需要标记为 operator , 才可以在解构声明中使用
     *   b.componentN()函数的返回值类型必须与属性类型一致
     */
    fun test_deconstruction1() {
        var person: Person = Person("Jone", 20, "ShangHai")
        person.mobile = "147323"

        var (name, age, addr, mobile) = person
        L.i("name: $name, age: $age, addr: $addr, mobile: $mobile")
    }

    fun test_deconstruction2() {

        var personA: Person = Person("Door", 22, "ShanDong")
        var personB: Person = Person("Green", 30, "BeiJing")
        var personC: Person = Person("Dark", 23, "YunNan")
        var personD: Person = Person("Tool", 26, "GuanDong")
        var personE: Person = Person("Mark", 24, "TianJin")
        var pers = listOf(personA, personB, personC, personD, personE)
        for ((name, age) in pers) {
            L.i("name: $name, age: $age")
        }
    }


}
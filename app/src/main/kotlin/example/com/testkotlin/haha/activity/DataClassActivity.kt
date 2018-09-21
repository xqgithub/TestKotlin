package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import example.com.testkotlin.R

/**
 * Created by XQ on 2018/1/6.
 * 数据类
 * 我们经常创建一些只保存数据的类
 */
class DataClassActivity : AppCompatActivity() {

    val TAG: String = "DataClassActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dataclass)
//        test0()
        test1()
    }


    data class Person(var name: String, var age: Int)

    data class MyInfo(var no: Int, var person: Person) {
        override fun hashCode(): Int {
            return super.hashCode()
        }
    }

    /**
     *对象复制
     */
    fun test0() {
        Log.i(TAG, "------- Log0 -------")//copy()函数实现的功能是复制一个对象，然后修改其一部分属性，但保持其他属性保持不变
        var per0: Person = Person("A", 20)
        var per1: Person = per0.copy(age = 15)
        Log.i(TAG, "per0: $per0")
        Log.i(TAG, "per1: $per1")
        Log.i(TAG, "------- Log1 -------")//copy并不是简单的复制，它会创建新的对象，对于基本类型的属性，其值会被拷贝并赋值
        per1.name = "B"
        Log.i(TAG, "per0: $per0")
        Log.i(TAG, "per1: $per1")
        Log.i(TAG, "------- Log2 -------")//“=”号赋值和copy()在执行机制上还是有区别的。在对copy使用时，还是要注意对引用类型的浅拷贝
        var per2: Person = Person("A", 20)
        var per3: Person = per2
        per3.name = "B"
        per3.age = 30
        Log.i(TAG, "per2: $per2")
        Log.i(TAG, "per3: $per3")
        Log.i(TAG, "------- Log3 -------")
        var info0: MyInfo = MyInfo(1, per0)
        var perAA = Person("AA", 30)
        var info1: MyInfo = info0.copy(no = 2)
        var info2: MyInfo = info0.copy(person = perAA)
        Log.i(TAG, "info0: $info0")
        Log.i(TAG, "info1: $info1")
        Log.i(TAG, "info2: $info2")
        Log.i(TAG, "------- Log4 -------")//但是对于引用类型，其只是将其地址传递过去，还是进行浅拷贝，并没有创建新的对象
        info1.person.name = "C"
        Log.i(TAG, "info0: $info0")
        Log.i(TAG, "info1: $info1")
        Log.i(TAG, "info2: $info2")
    }

    /**
     *数据的解构
     */
    fun test1() {
        val jane = Person("路飞", 19)
        val (n, a) = jane
        Log.i(TAG, "$n, $a years of age")//路飞, 19 years of age
    }


}
package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.safframework.log.L
import example.com.testkotlin.haha.domain.Inherited
import example.com.testkotlin.haha.domain.Person

/**
 * Created by XQ on 2017/9/15.
 * 类和继承
 */
class ClassInheritActivity : AppCompatActivity() {

    val TAG: String = "ClassInheritActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        testPerson()
//        testPerson2()
        testBase()
    }

    fun testPerson() {
        var person: Person = Person("wahaha")
        person.lastName = "haizeiwang"
        println("$TAG----->" + person.lastName)
        L.i("person.lastName----->" + person.lastName)

        person.no = 7
        L.i("person.no----->" + person.no)

        person.no = 17
        L.i("person.no----->" + person.no)
    }


    fun testPerson2() {
//        var person: Person = Person("wahaha")
        Person("luefei", 17)
    }

    fun testBase() {
        var inheritedclass: Inherited = Inherited("路飞", "索隆")
//        inheritedclass.allowRewrite()
//        inheritedclass.unAllowRewrite()
//        inheritedclass.Baz().a()
        inheritedclass.Baz().b()
    }


}
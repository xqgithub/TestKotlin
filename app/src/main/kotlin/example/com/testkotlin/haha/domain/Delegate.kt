package example.com.testkotlin.haha.domain

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by beijixiong on 2018/9/21.
 * 委托属性类
 * 1.委托属性不需要实现任何的接口，但是要提供getValue()方法(如果是var的话要提供setValue()方法)，方法前加operator关键字。
 */
class Delegate<T : Any> : ReadWriteProperty<Any?, T> {
    var delegate_value: String = ""
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("Property ${property.name} should be initialized before get.")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }


//    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
////        L.i("$thisRef, '${property.name}',$delegate_value")
//        return delegate_value
//    }
//
//    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//        delegate_value = value
////        L.i("$value has been assigned to '${property.name} in $thisRef.'")
//    }


}
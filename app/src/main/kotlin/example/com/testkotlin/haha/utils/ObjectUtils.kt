package example.com.testkotlin.haha.utils

import com.safframework.log.L

/**
 * Created by beijixiong on 2018/9/21.
 */


/**
 * 饿汉式加载
 * 1.如果构造方法中存在过多的处理，会导致加载这个类时比较慢，可能引起性能问题
 * 2.如果使用饿汉式的话，只进行了类的装载，并没有实质的调用，会造成资源的浪费
 */
object SimpleSington {
    fun a() {
        L.i("SimpleSington这是一个【一个饿汉式】的单例")
    }
}

/**
 * 懒汉式加载
 * 显式声明构造方法为private
 * companion object用来在class内部声明一个对象
 * LazySingleton的实例instance 通过lazy来实现懒汉式加载
 * lazy默认情况下是线程安全的，这就可以避免多个线程同时访问生成多个实例的问题
 */
class LazySingleton private constructor() {
    companion object {
        val instance: LazySingleton by lazy { LazySingleton() }
    }

    fun a() {
        L.i("LazySingleton这是一个【一个懒汉式】的单例")
    }
}


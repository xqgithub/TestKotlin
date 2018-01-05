package example.com.testkotlin.haha.test

/**
 * 00001
 * Created by XQ on 2018/1/5.
 * 可见性修饰符
 */
open class TestOuter {
    private val a = 1
    protected val b = 2
    val c = 3 // internal by default
    public val d: Int = 4 // return type required

    protected class Nested {
        public val e: Int = 5
    }
}
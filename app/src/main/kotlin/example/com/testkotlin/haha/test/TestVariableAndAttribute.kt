package example.com.testkotlin.haha.test

/**
 * Created by admin on 2017/8/17.
 * 变量和属性
 */
class TestVariableAndAttribute {


    companion object {
        val i: Int = 7
        val d: Double = i.toDouble()

        fun test() {
            println("d----->" + d)
        }

        val c: Char = 'c'
        val ii: Int = c.toInt()

        fun test1() {
            println("ii----->" + ii)
        }
    }
}
package example.com.testkotlin.haha.domain

import com.safframework.log.L
import example.com.testkotlin.haha.domaininterface.EntrustBase
import kotlin.properties.Delegates

/**
 * Created by beijixiong on 2018/9/21.
 * 委托实现类
 */
class EntrustBaseImpl(val a: String) : EntrustBase {

    override val testmessage_a = "路飞"


    override fun a() {
        L.i("EntrustBaseImpl 是: $a == $testmessage_a")
    }

    /**
     * 自定义 委托属性
     */
    var text_delegate_a: String by Delegate()
    var text_delegate_b: String by Delegate()
    fun b() {
        L.i("自定义委托属性text_delegate_a：----->$text_delegate_a")
        L.i("自定义委托属性text_delegate_b：----->$text_delegate_b")
    }

    /**
     * 延迟属性 lazy()
     * 1.lazy()接收一个Lambdas表达式，然后并返回一个Lazy <T>的实例，它可以作为实现lazy属性的委托
     * 2.lazy属性，只能声明为 val的，即它是只能get的
     * 3.LazyThreadSafetyMode.SYNCHRONIZED 同步
     * 4.LazyThreadSafetyMode.PUBLICATION  内部的计算过程可能被多次访问，但内部的属性是一个Volatile修饰的属性，所以在多线程环境中，被第一次访问获取数据后，此后的其它线程都共享该值
     * 5.LazyThreadSafetyMode.NONE         未对多线程环境，做任何处理。所以在多线程环境中使用，会造成：计算和返回值都可能处在多个线程中。
     */
    val lazyValue: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        L.i("computed!")
        "Hello"
    }

    fun c() {
        L.i("延迟属性lazyValue1：----->$lazyValue")
        L.i("延迟属性lazyValue2：----->$lazyValue")
    }

    /**
     * 观察属性 Observable
     * 1.Delegates.observable()有两个参数：初始化值和handler，每次对属性赋值操作，都会回调该handler方法（在属性赋值后执行），该方法里面有三个参数，分别是：被赋值的属性，旧值和新值。
     * 2.<no name>就是初始化值，{}包住的代码块就是handler方法，pro, old, new就是该方法的三个参数
     * 3.如果需要拦截修改属性值动作并禁止修改，可以使用vetoable()取代observable()
     * 4.property：在这指属性name;
     *   oldValue： 旧值，首次即为指定的初始值
     *   newValue：新set的值
     *   最终属性值=new值
     * 5.Delegates.vetoable() true:属性值=new值; false：属性值=old值
     */
    var test_observable1: String by Delegates.observable("<no name>") { prop, old, new ->
        //        L.i("$prop->$old -> $new")
    }
    var test_observable2: String by Delegates.vetoable("<no name>") { prop, old, new ->
        //        L.i("$old -> $new")
        true
    }

    fun d() {
        L.i("观察属性test_observable1：----->$test_observable1")
        L.i("观察属性test_observable2：----->$test_observable2")
    }

    /**
     * Map委托属性
     * 1.可以用Map作为委托用于委托属性，多用于JSON解析上
     * 2.
     */
    fun e(map: Map<String, Any?>) {
        val name: String by map
        val age: Any by map
        val company: String by map
        val address: String by map
        val email: String by map
        L.i("Map委托属性name：----->$name")
        L.i("Map委托属性age：----->$age")
    }


    init {
        init()
    }

    fun init() {
        text_delegate_a = "娜美"
        text_delegate_b = "乔巴"

        test_observable1 = "罗杰"
        test_observable1 = "路飞"

        test_observable2 = "罗杰"
        test_observable2 = "路飞"
    }
}
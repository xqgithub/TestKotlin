package example.com.testkotlin.haha.activity

import android.os.Bundle
import example.com.testkotlin.R
import example.com.testkotlin.haha.base.BaseActivity

/**
 * Created by beijixiong on 2018/9/26.
 * 协程
 * 线程（Thraed）是比进程小一级的的运行单位，多线程实现系统资源上下文调用，是编程语言交付系统内核来进行的（可能是并发，也可能是伪并发），大部分的编程语言的多线程实现都是抢占式的，而对于这些线程的控制，编程语言无法直接控制，需要通过系统内核来进行，由系统内核决定最终的行为
 * 协程（Coroutine）是在语言层面实现“多线程”这个过程，一般在代码中以串行的方式表达并发逻辑，由于是在编程语言层面模拟这一过程，而非涉及到硬件层面，在编程语言层面可以完全控制这一过程，可以这么说，协程是软件层面模拟硬件层面的多线程；但不是说协程就一定是单线程，具体的实现要看具体编程语言的实现，kotlin的协程实现可能是单线程，也可能是多线程；
 */
class CoroutinesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        test_coroutines1()
//        test_coroutines2()
//        test_coroutines3()

//        test_buildSequence()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_coroutines
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    /**
     * 协程可以用于解决高负荷网络 IO、文件 IO、CPU/GPU 密集型任务等
     * 1.特殊修饰符 suspend 修饰的函数被称为挂起函数, suspend方法的本质是异步返回，suspend方法并不总是引起协程挂起, 只有其内部的数据未准备好时才会
     * 2.挂起函数只能在协程中和其他挂起函数中调用，不能在其他部分使用，所以要启动一个协程，挂起函数是必须的
     * 3.async方法作用和launch方法基本一样, 创建一个协程并立即启动,但是async创建的协程可以携带返回值.
     */
//    fun test_coroutines1() {
//        //创建一个协程
//        val deferred = GlobalScope.async {
//            delay(1000)//协程的delay作用等同于线程里的sleep, 都是休息一段时间, 但不同的是delay不会阻塞当前线程
//            L.i("${Thread.currentThread().name}  World!")
//        }
//        L.i("${Thread.currentThread().name}  Hello, ")
//        Thread.sleep(2000)
//    }

    //launch方法
//    fun test_coroutines2() {
//        val job: Job = GlobalScope.launch {
//            var i = 1
//            while (true) {
//                L.i("$i sheep")
//                i++
//                delay(500)// 每半秒数一只, 一秒可以输两只
//            }
//        }
//        Thread.sleep(1000L)// 在主线程睡眠期间, 协程里已经数了两只羊
//        job.cancel()
//        Thread.sleep(1000L)
//        L.i("主线程已经结束")
//    }

    //async方法
    //a.join()：类似Thread.join
    //b.cancel()：协程取消
    //c.await()：等待直接获取协程返回值
//    fun test_coroutines3() {
//        GlobalScope.launch {
//            L.i("协程开始")
//            // 任务1会立即启动, 并且会在别的线程上并行执行
//            val deferred1 = GlobalScope.async { requestDataAsync1() }
//
//            // 上一个步骤只是启动了任务1, 并不会挂起当前协程
//            // 所以任务2也会立即启动, 也会在别的线程上并行执行
//            val deferred2 = GlobalScope.async { requestDataAsync2() }
//            L.i(" data1 = ${deferred1.await()}")
//
//            // 然后等待任务2完成（约是3000ms）
//            L.i("data1 = ${deferred1.await()}, data2 = ${deferred2.await()}\n协程结束")
//        }
////        Thread.sleep(10000L) // 继续无视这个sleep
//    }

//    suspend fun requestDataAsync1(): String {
//        delay(1000L)
//        return "requestDataAsync1"
//    }

//    suspend fun requestDataAsync2(): String {
//        delay(3000L)
//        return "requestDataAsync2"
//    }

    /**
     * 生成器 API
     * buildSequence()
     * buildIterator():buildIterator() 的工作方式类似于 buildSequence()，但返回一个惰性迭代器
     */
//    fun test_buildSequence() {
//        val lazySeq = sequence {
//            L.i("START ")
//            for (i in 1..5) {
//                yield(i)
//                L.i("STEP ")
//            }
//            L.i("END")
//        }
//        lazySeq.take(5).forEach { L.i("$it ") }
//    }


}
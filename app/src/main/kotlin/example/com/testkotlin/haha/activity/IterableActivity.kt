package example.com.testkotlin.haha.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.testkotlin.R

/**
 * Created by XQ on 2018/1/11.
 * 集合归纳
 */
class IterableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iterable)
        test1()
    }

    /**
     *list在Kotlin中也就是一个只读的集合
     */
    fun test0() {
        val list = listOf<String>(//新建list
                "瓦洛兰",
                "德玛西亚",
                "班德尔城",
                "诺克萨斯",
                "祖安",
                "皮尔特沃夫",
                "艾欧尼亚",
                "李青",
                "阿利斯塔",
                "希维尔",
                "潘森",
                "伊泽瑞尔",
                "雷克顿",
                "古拉加斯",
                "奥利安娜",
                "崔斯塔娜",
                "泰达米尔",
                "马尔扎哈",
                "卡西奥佩娅",
                "艾尼维亚"
        )


        val count = list.size     //集合中元素的数量  Int
        val isNull = list.isEmpty()   //判断集合是否为空  Boolean
        val isContains = list.contains("李青")  //判断集合中是否包含某种元素     Boolean
        val list2 = listOf<String>(
                "瓦洛兰",
                "德玛西亚",
                "班德尔城",
                "诺克萨斯",
                "祖安"
        )

        val isContainsAll = list.containsAll(list2)   //判断集合中是否包含另一个集合    Boolean
        val indexStr = list.get(2)    //查询集合中某个位置的元素值 <E>
        val index = list.indexOf("李青")    //返回集合中某个元素首次出现的索引，如果不存在则返回-1 Int
        val lastIndex = list.lastIndexOf("李青")    //返回集合中某个元素最后出现的索引，如果不存在则返回-1   Int

        val iterator = list.iterator()    //返回该只读集合的元素迭代器     Iterator
        val listIterator = list.listIterator()    //返回一个集合的迭代器    ListIterator
        val listIteratorIndex = list.listIterator(2)  //从指定位置开始，返回一个集合的迭代器    ListIterator
        val subList = list.subList(1, 9)   //返回集合中从1到9之间的集合    List
    }

    /**
     *对集合进行修改，我们应该使用MutableList
     */
    fun test1() {
        val mutableList = mutableListOf<String>(
                "伊泽瑞尔",
                "雷克顿",
                "古拉加斯",
                "奥利安娜",
                "崔斯塔娜",
                "泰达米尔",
                "马尔扎哈",
                "卡西奥佩娅",
                "艾尼维亚"
        )

        val list2 = listOf<String>(
                "瓦洛兰",
                "德玛西亚",
                "班德尔城",
                "诺克萨斯",
                "祖安"
        )
        val isAddOk = mutableList.add("祖安")     //添加一个元素，返回true或false   Boolean
        val isAddIndexOk = mutableList.add(2, "班德尔城")  //在指定位置添加一个元素   Unit
        val isRemoveOk = mutableList.remove("李青")    //移除集合中的一个元素，返回true或false    Boolean
        val isRemoveAtOk = mutableList.removeAt(3)    //移除指定为位置的元素    <E>
        val isAddAllOk = mutableList.addAll(list2)   //添加另一个集合，返回true或false       Boolean
        val isRemoveAllOk = mutableList.removeAll(list2)  //移除一个集合，返回true或false   Boolean
        val isSetOk = mutableList.set(2, "诺克萨斯")   //替换指定位置的元素，返回原元素   <E>
        val isClearOk = mutableList.clear()   //清空集合中得元素 Unit
        val list4 = mutableList.toList()  //tolist是一个扩展函数，可以赋值list内的内容，返回一个只读的list
    }

    /**
     *Map是一个存放键和值的集合，每一个元素都包含键和值。Kotlin中Map和list一样，也分为只读和可变两种Map。
     */
    fun test2() {
        val map = mapOf<Int, String>(
                1 to "伊泽瑞尔", 2 to "雷克顿", 3 to "古拉加斯", 4 to "泰达米尔"
        )
        val hashMap = hashMapOf<Int, String>(
                1 to "伊泽瑞尔", 2 to "雷克顿", 3 to "古拉加斯", 4 to "泰达米尔"
        )

        val count = map.size  //获取元素数量
        val keys = map.keys   //返回map中key的集合
        keys.forEach(::print)   //输出Log：1,2,3,4
        val values = map.values    //返回map中key的集合
        values.forEach(::print)     //输出Log：伊泽瑞尔,雷克顿,古拉加斯,泰达米尔
        val entry = map.entries   //返回键/值对集合
        entry.forEach {
            println("key: ${it.key} , value: ${it.value}")
        }       //输出key:1 , value:伊泽瑞尔  key:2...

        val isEmpty = map.isEmpty()   //判断集合是否为空 Boolean
        val isContainsKey = map.containsKey(3)    //判断集合中是否包含某个key
        val isContainsValue = map.containsValue("雷克顿")    //判断集合中是否包含某个value
        val valueStr = map.get(2) //获取指定key的元素值，没有则返回null
    }


}
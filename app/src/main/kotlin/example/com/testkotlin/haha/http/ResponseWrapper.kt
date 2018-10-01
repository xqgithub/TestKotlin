package example.com.testkotlin.haha.http

/**
 * Created by beijixiong on 2018/10/1.
 * 返回的数据中，最外层都包裹了一层信息，以表示请求成功或失败，中间data才是具体数据，所以定义数据类(实体类)时，需要定义成如下形式
 */
//{
//    "code": "200",
//    "data": [
//    {
//        "name": "Tom",
//        "age": 12,
//        "money": 100.5
//    },
//    {
//        "name": "Bob",
//        "age": 13,
//        "money": 200.5
//    }
//    ],
//    "message": "客户端请求成功"
//}
data class ResponseWrapper<T>(var code: Int, var data: T, var message: String)
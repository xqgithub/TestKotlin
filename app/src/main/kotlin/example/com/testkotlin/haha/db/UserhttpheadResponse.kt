package example.com.testkotlin.haha.db

import java.io.Serializable

/**
 * Created by beijixiong on 2018/10/9.
 */
class UserhttpheadResponse {
    var uid: Int = 0//用户的账号ID                                          $$$$$
    var unm: String? = null//用户的账号名                                       $$$$$
    var uip: String? = null//用户访问此地址时的IP地址                             $$$$$
    var locbean: LocBean? = null

    constructor() {}
    constructor(uid: Int, unm: String, uip: String, locbean: LocBean) {
        this.uid = uid
        this.unm = unm
        this.uip = uip
        this.locbean = locbean
    }

    class LocBean : Serializable {
        var type: String? = null
        var coordinates: List<Double>? = null

        constructor() {}
        constructor(coordinates: List<Double>, type: String) {
            this.coordinates = coordinates
            this.type = type
        }
    }
}
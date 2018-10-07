package example.com.testkotlin.haha.db


/**
 * Created by beijixiong on 2018/10/3.
 */
data class CompanyData(val map: MutableMap<String, Any?>) {

    var _id: Long by map
    var name: String by map
    var address: String by map
    var code: Long by map

    constructor() : this(HashMap()) {
    }

    constructor(id: Long, name: String, address: String, code: Long) : this(HashMap()) {
        this._id = id
        this.name = name
        this.address = address
        this.code = code
    }
}
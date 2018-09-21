package example.com.testkotlin.haha.domain

import example.com.testkotlin.haha.domaininterface.EntrustBase

/**
 * Created by beijixiong on 2018/9/21.
 * 委托类
 */
class EntrustBaseDerived(entrustBase: EntrustBase) : EntrustBase by entrustBase {
    //EntrustBaseImpl中不会访问到这个属性
    override val testmessage_a = "索隆"
}

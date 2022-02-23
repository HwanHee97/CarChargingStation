package com.example.carchargingstation.RpDataModel

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "response")
data class ChargingStationState(
    @Element
    val header: Header,
    @Element
    val body: Body
)
@Xml(name = "header")
data class Header(
    @PropertyElement
    val resultCode: Int,
    @PropertyElement
    val resultMsg: String,
)
@Xml(name = "body")
data class Body(
    @Element
    val items: Items,
    @PropertyElement
    val numOfRows: Int,
    @PropertyElement
    val pageNo: Int,
    @PropertyElement
    val totalCount: Int,
)
@Xml
data class Items(
    @Element(name = "item")
    val item: List<Item>
)

@Xml
data class Item(
    @PropertyElement(name = "addr")
    var addr: String?,
    @PropertyElement(name = "chargeTp")
    var chargeTp: Int?,
    @PropertyElement(name = "cpId")
    var cpId: Int?,
    @PropertyElement(name = "cpNm")
    var cpNm: String?,
    @PropertyElement(name = "cpStat")
    var cpStat: Int?,
    @PropertyElement(name = "cpTp")
    var cpTp: Int?,
    @PropertyElement(name = "csId")
    var csId: Int?,
    @PropertyElement(name = "csNm")
    var csNm: String?,
    @PropertyElement(name = "lat")
    var lat: Long?,
    @PropertyElement(name = "longi")
    var longi: Long?,
    @PropertyElement(name = "statUpdateDatetime")
    var statUpdateDatetime: String?
)
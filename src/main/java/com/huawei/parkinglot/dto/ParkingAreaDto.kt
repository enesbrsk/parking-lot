package com.huawei.parkinglot.dto
import com.fasterxml.jackson.annotation.JsonInclude


data class ParkingAreaDto @JvmOverloads constructor(

    var id: Long? = null,
    var name: String? = null,
    var capacity: Int? = null,
    var available: Int? = null,
    var city: String? = null,

    @JsonInclude(JsonInclude.Include.NON_EMPTY) //price listesi bos ise Json'da gosterme
    var priceList: List<PriceListDto>? = ArrayList()

)
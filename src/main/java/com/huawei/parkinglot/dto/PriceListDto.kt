package com.huawei.parkinglot.dto
import com.huawei.parkinglot.entity.ParkingArea
import java.math.BigDecimal

data class PriceListDto @JvmOverloads constructor(
    var id: Long? = null,
    var startHour: Int? = null,
    var endHour: Int? = null,
    var price: BigDecimal? = null,
)

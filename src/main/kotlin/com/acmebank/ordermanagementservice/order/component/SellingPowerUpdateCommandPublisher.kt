package com.acmebank.ordermanagementservice.order.component

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi

interface SellingPowerUpdateCommandPublisher {
    fun publishEvent(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi)
}

package com.acmebank.ordermanagementservice.order.domain

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi

interface SellingPowerUpdateCommandPublisher {
    fun publishEvent(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi)
}

package com.acmebank.ordermanagementservice.order.domain

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi

interface BuyingPowerUpdateCommandPublisher {
    fun publishEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi)
}

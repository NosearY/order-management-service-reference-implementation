package com.acmebank.ordermanagementservice.order.component

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi

interface BuyingPowerUpdateCommandPublisher {
    fun publishEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi)
}

package com.acmebank.ordermanagementservice.corporateaction.components

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi

interface BuyingPowerUpdateCommandApiPublisher {
    fun publishEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi)
}

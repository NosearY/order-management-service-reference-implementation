package com.acmebank.ordermanagementservice.corporateaction.domain

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi

interface BuyingPowerUpdateCommandApiPublisher {
    fun publishEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi)
}

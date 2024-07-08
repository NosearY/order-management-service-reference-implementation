package com.acmebank.ordermanagementservice.corporateaction.components

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi

interface SellingPowerUpdateCommandPublisher {
    fun publishEvent(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi)
}

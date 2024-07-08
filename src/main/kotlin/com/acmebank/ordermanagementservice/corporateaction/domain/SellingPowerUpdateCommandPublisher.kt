package com.acmebank.ordermanagementservice.corporateaction.domain

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi

interface SellingPowerUpdateCommandPublisher {
    fun publishEvent(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi)
}

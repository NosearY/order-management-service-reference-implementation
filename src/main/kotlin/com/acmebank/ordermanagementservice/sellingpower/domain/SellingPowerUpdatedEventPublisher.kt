package com.acmebank.ordermanagementservice.sellingpower.domain

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent

interface SellingPowerUpdatedEventPublisher {
    fun publishEvent(sellingPowerUpdatedEvent: SellingPowerUpdatedEvent)
}

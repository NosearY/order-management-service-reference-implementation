package com.acmebank.ordermanagementservice.sellingpower.component

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent

interface SellingPowerUpdatedEventPublisher {
    fun publishEvent(sellingPowerUpdatedEvent: SellingPowerUpdatedEvent)
}

package com.acmebank.ordermanagementservice.buyingpower.component

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent

interface BuyingPowerUpdatedEventPublisher {
    fun publishEvent(buyingPowerUpdatedEvent: BuyingPowerUpdatedEvent)
}

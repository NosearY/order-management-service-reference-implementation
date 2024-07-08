package com.acmebank.ordermanagementservice.buyingpower.domain

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent

interface BuyingPowerUpdatedEventPublisher {
    fun publishEvent(buyingPowerUpdatedEvent: BuyingPowerUpdatedEvent)
}

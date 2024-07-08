package com.acmebank.ordermanagementservice.buyingpower.adapters.springevents

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.buyingpower.domain.BuyingPowerUpdatedEventPublisher
import org.springframework.context.ApplicationEventPublisher

class SpringBuyingPowerUpdatedEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : BuyingPowerUpdatedEventPublisher {
    override fun publishEvent(buyingPowerUpdatedEvent: BuyingPowerUpdatedEvent) {
        applicationEventPublisher.publishEvent(buyingPowerUpdatedEvent)
    }
}

package com.acmebank.ordermanagementservice.buyingpower.adapter.springevents

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.buyingpower.component.BuyingPowerUpdatedEventPublisher
import org.springframework.context.ApplicationEventPublisher

class SpringBuyingPowerUpdatedEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : BuyingPowerUpdatedEventPublisher {
    override fun publishEvent(buyingPowerUpdatedEvent: BuyingPowerUpdatedEvent) {
        applicationEventPublisher.publishEvent(buyingPowerUpdatedEvent)
    }
}

package com.acmebank.ordermanagementservice.sellingpower.adapter.springevent

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.sellingpower.component.SellingPowerUpdatedEventPublisher
import org.springframework.context.ApplicationEventPublisher

class SpringSellingPowerUpdatedEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : SellingPowerUpdatedEventPublisher {
    override fun publishEvent(sellingPowerUpdatedEvent: SellingPowerUpdatedEvent) {
        applicationEventPublisher.publishEvent(sellingPowerUpdatedEvent)
    }
}

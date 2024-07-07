package com.acmebank.ordermanagementservice.notifications.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class NotificationBuyingPowerUpdatedEventListener {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onBuyingPowerUpdatedEvent(buyingPowerUpdatedEvent: BuyingPowerUpdatedEvent) {
        logger.info("Received $buyingPowerUpdatedEvent")
    }
}

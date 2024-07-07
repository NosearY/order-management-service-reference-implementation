package com.acmebank.ordermanagementservice.notifications.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class NotificationAnalysisSellingPowerUpdatedEventListener {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onSellingPowerUpdatedEvent(sellingPowerUpdatedEvent: SellingPowerUpdatedEvent) {
        logger.info("Received $sellingPowerUpdatedEvent")
    }
}

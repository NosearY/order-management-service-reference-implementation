package com.acmebank.ordermanagementservice.notifications.application

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

@AllOpen
class NotificationAnalysisSellingPowerUpdatedEventListener(
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(sellingPowerUpdatedEvent: SellingPowerUpdatedEvent) {
        logger.info("Received $sellingPowerUpdatedEvent")
    }

}

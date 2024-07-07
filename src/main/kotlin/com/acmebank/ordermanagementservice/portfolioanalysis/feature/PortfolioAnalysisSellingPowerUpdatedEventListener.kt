package com.acmebank.ordermanagementservice.portfolioanalysis.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class PortfolioAnalysisSellingPowerUpdatedEventListener {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(sellingPowerUpdatedEvent: SellingPowerUpdatedEvent) {
        logger.info("Received $sellingPowerUpdatedEvent")
    }
}

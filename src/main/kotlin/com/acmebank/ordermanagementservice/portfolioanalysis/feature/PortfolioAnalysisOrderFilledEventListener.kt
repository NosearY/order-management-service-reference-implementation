package com.acmebank.ordermanagementservice.portfolioanalysis.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.portfolioanalysis.ports.PortfolioOnOrderFilledEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@AllOpen
@Component
class PortfolioAnalysisOrderFilledEventListener : PortfolioOnOrderFilledEvent {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onOrderFilledEvent(onOrderFilledEvent: OrderFilledEvent) {
        logger.info("Received $onOrderFilledEvent")
    }
}

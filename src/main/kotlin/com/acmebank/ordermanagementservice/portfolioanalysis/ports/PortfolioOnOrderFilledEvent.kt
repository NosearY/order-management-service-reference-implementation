package com.acmebank.ordermanagementservice.portfolioanalysis.ports

import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import org.springframework.modulith.events.ApplicationModuleListener

interface PortfolioOnOrderFilledEvent {
    @ApplicationModuleListener
    fun onOrderFilledEvent(onOrderFilledEvent: OrderFilledEvent)
}

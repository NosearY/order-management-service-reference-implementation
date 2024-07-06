package com.acmebank.ordermanagementservice.sellingpower.application.eventlistener

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerDomainService
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

@AllOpen
class SellingPowerOrderFilledEventListener(
    private val sellingPowerDomainService: SellingPowerDomainService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(orderFilledEvent: OrderFilledEvent) {
        logger.info("Received $orderFilledEvent")

        sellingPowerDomainService.updateSellingPower(orderFilledEvent)
    }
}

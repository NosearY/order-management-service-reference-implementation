package com.acmebank.ordermanagementservice.buyingpower.application.eventlistener

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerDomainService
import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

@AllOpen
class BuyingPowerOrderFilledEventListener(
    private val buyingPowerDomainService: BuyingPowerDomainService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(orderFilledEvent: OrderFilledEvent) {
        logger.info("Received $orderFilledEvent")

        buyingPowerDomainService.updateBuyingPower(
            BuyingPowerUpdateCommand(
                orderFilledEvent.customerId,
                (orderFilledEvent.priceLimit * orderFilledEvent.quantity.toBigDecimal()).negate(),
            ),
        )
    }
}

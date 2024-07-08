package com.acmebank.ordermanagementservice.notifications.adapters

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.notifications.ports.NotificationOnOrderFilledEvent
import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@AllOpen
@Component
class NotificationOrderFilledEventListenerNotification : NotificationOnOrderFilledEvent {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onOrderFilledEvent(corporateActionEffectiveEvent: OrderFilledEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

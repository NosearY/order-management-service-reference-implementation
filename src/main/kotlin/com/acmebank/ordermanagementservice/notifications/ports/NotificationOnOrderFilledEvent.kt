package com.acmebank.ordermanagementservice.notifications.ports

import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import org.springframework.modulith.events.ApplicationModuleListener

interface NotificationOnOrderFilledEvent {
    @ApplicationModuleListener
    fun onOrderFilledEvent(corporateActionEffectiveEvent: OrderFilledEvent)
}

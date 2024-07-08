package com.acmebank.ordermanagementservice.order.component.service

import com.acmebank.ordermanagementservice.order.OrderFilledEvent

interface OrderFilledEventPublisher {
    fun publishEvent(orderFilledEvent: OrderFilledEvent)
}

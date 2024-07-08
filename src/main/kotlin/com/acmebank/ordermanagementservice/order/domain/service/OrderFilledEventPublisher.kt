package com.acmebank.ordermanagementservice.order.domain.service

import com.acmebank.ordermanagementservice.order.OrderFilledEvent

interface OrderFilledEventPublisher {
    fun publishEvent(orderFilledEvent: OrderFilledEvent)
}

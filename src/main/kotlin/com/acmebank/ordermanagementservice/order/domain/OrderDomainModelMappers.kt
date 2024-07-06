package com.acmebank.ordermanagementservice.order.domain

import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand

fun OrderCreationCommand.toOrder() =
    Order(
        customerId = customerId,
        symbol = symbol,
        quantity = quantity,
        priceLimit = priceLimit,
        orderDirection = orderDirection,
    )

fun Order.toOrderFilledEvent() =
    OrderFilledEvent(
        customerId,
        symbol,
        quantity,
        priceLimit,
    )

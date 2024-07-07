package com.acmebank.ordermanagementservice.order.component

import com.acmebank.ordermanagementservice.order.component.model.Order
import com.acmebank.ordermanagementservice.order.component.model.OrderCreationCommand

fun OrderCreationCommand.toOrder() =
    Order(
        account = account,
        symbol = stock,
        quantity = quantity,
        priceLimit = priceLimit,
        orderDirection = orderDirection,
    )

package com.acmebank.ordermanagementservice.order.domain

import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand

fun OrderCreationCommand.toOrder() =
    Order(
        account = account,
        symbol = stock,
        quantity = quantity,
        priceLimit = priceLimit,
        orderDirection = orderDirection,
    )

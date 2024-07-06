package com.acmebank.ordermanagementservice.order.application

import com.acmebank.ordermanagementservice.order.application.dto.OrderResponse
import com.acmebank.ordermanagementservice.order.domain.model.Order

fun Order.toOrderDTO() =
    OrderResponse(
        referenceNo,
        customerId,
        symbol,
        quantity,
        priceLimit,
    )

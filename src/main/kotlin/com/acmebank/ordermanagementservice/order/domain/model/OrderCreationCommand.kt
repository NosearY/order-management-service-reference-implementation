package com.acmebank.ordermanagementservice.order.domain.model

import java.math.BigDecimal

data class OrderCreationCommand(
    val customerId: String,
    val orderDirection: OrderDirection,
    val symbol: String,
    val quantity: Float,
    val priceLimit: BigDecimal,
)

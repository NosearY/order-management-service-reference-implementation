package com.acmebank.ordermanagementservice.order

import java.math.BigDecimal

data class OrderFilledEvent(
    val customerId: String,
    val symbol: String,
    val quantity: Float,
    val priceLimit: BigDecimal,
)

package com.acmebank.ordermanagementservice.order.ports.dto

import java.math.BigDecimal

data class OrderResponse(
    val referenceNo: String,
    val customerId: String,
    val symbol: String,
    val quantity: Float,
    val priceLimit: BigDecimal,
)

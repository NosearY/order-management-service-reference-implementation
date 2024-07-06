package com.acmebank.ordermanagementservice.order.domain.model

import java.math.BigDecimal
import java.util.*

data class Order(
    val id: UUID,
    val referenceNo: String,
    val customerId: String,
    val symbol: String,
    val quantity: Float,
    val priceLimit: BigDecimal
)
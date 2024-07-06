package com.acmebank.ordermanagementservice.order.domain.model

import com.acmebank.ordermanagementservice.marketdata.Stock
import java.math.BigDecimal

data class OrderCreationCommand(
    val customerId: String,
    val orderDirection: OrderDirection,
    val stock: Stock,
    val quantity: Float,
    val priceLimit: BigDecimal,
)

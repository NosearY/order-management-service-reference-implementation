package com.acmebank.ordermanagementservice.sellingpower

import com.acmebank.ordermanagementservice.marketdata.Stock
import java.time.Instant

data class SellingPowerUpdatedEvent(
    val customerId: String,
    val stock: Stock,
    val quantity: Float,
    val delta: Float,
    val effectiveTimeStamp: Instant
)

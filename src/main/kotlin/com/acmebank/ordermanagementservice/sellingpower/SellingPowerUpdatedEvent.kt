package com.acmebank.ordermanagementservice.sellingpower

import java.time.Instant

data class SellingPowerUpdatedEvent(
    val customerId: String,
    val symbol: String,
    val quantity: Float,
    val delta: Float,
    val effectiveTimeStamp: Instant,
)

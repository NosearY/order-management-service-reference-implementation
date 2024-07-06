package com.acmebank.ordermanagementservice.buyingpower

import java.math.BigDecimal
import java.time.Instant

data class BuyingPowerUpdatedEvent(val customerId: String, val balance: BigDecimal, val delta: BigDecimal, val effectiveTimeStamp: Instant)

package com.acmebank.ordermanagementservice.buyingpower

import java.math.BigDecimal

data class BuyingPowerUpdateCommandApi(
    val customerId: String,
    val delta: BigDecimal,
)

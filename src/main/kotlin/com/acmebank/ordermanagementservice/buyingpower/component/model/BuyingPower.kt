package com.acmebank.ordermanagementservice.buyingpower.component.model

import java.math.BigDecimal

data class BuyingPower(
    val customerId: String,
    val balance: BigDecimal,
)

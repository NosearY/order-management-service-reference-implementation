package com.acmebank.ordermanagementservice.buyingpower.domain.model

import java.math.BigDecimal

data class BuyingPowerUpdateCommand(
    val customerId: String,
    val delta: BigDecimal,
)

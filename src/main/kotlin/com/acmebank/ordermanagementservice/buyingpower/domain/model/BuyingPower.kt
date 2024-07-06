package com.acmebank.ordermanagementservice.buyingpower.domain.model

import java.math.BigDecimal

data class BuyingPower(val customerId: String, val balance: BigDecimal)

package com.acmebank.ordermanagementservice.buyingpower

import java.math.BigDecimal

data class BuyingPowerApi(val customerId: String, val balance: BigDecimal)

package com.acmebank.ordermanagementservice.buyingpower

import java.math.BigDecimal

interface BuyingPowerApiService {
    fun getAvailableBuyingPower(customerId: String): BigDecimal
}

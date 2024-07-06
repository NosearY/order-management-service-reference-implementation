package com.acmebank.ordermanagementservice.sellingpower

import java.math.BigDecimal

interface SellingPowerApiService {
    fun getAvailableSellingPower(
        customerId: String,
        symbol: String,
    ): BigDecimal
}

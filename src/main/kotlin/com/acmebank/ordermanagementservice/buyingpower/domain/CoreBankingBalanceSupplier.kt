package com.acmebank.ordermanagementservice.buyingpower.domain

import java.math.BigDecimal

interface CoreBankingBalanceSupplier {
    fun getAvailableBalance(customerId: String): BigDecimal

    fun updateAvailableBalance(
        customerId: String,
        delta: BigDecimal,
    ): BigDecimal
}

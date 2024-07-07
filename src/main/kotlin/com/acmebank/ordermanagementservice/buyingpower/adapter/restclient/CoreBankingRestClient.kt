package com.acmebank.ordermanagementservice.buyingpower.adapter.restclient

import com.acmebank.ordermanagementservice.buyingpower.component.CoreBankingBalanceSupplier
import java.math.BigDecimal

class CoreBankingRestClient(
    private val remoteDb: MutableMap<String, BigDecimal>,
) : CoreBankingBalanceSupplier {
    override fun getAvailableBalance(customerId: String): BigDecimal = remoteDb.getOrDefault(customerId, BigDecimal("100"))

    override fun updateAvailableBalance(
        customerId: String,
        delta: BigDecimal,
    ): BigDecimal =
        remoteDb.compute(customerId) { _, v ->
            (v ?: BigDecimal.ZERO) + delta
        } ?: BigDecimal.ZERO
}

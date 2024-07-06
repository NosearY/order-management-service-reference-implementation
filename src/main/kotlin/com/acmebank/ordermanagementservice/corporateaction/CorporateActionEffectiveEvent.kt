package com.acmebank.ordermanagementservice.corporateaction

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.marketdata.Stock
import java.math.BigDecimal
import java.time.Instant

data class CorporateActionEffectiveEvent(
    val account: Account,
    val stock: Stock,
    val cashUpdates: List<CashUpdate>,
    val assetUpdate: List<AssetUpdate>,
    val effectiveTimestamp: Instant,
)

data class CashUpdate(
    val amount: BigDecimal,
)

data class AssetUpdate(
    val quantity: Float,
    val stock: Stock,
)

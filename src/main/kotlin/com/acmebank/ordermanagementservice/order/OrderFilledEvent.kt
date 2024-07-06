package com.acmebank.ordermanagementservice.order

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.marketdata.Stock
import java.math.BigDecimal

data class OrderFilledEvent(
    val account: Account,
    val stock: Stock,
    val quantity: Float,
    val priceLimit: BigDecimal,
)

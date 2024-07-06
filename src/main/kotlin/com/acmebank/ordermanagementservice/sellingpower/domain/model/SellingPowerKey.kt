package com.acmebank.ordermanagementservice.sellingpower.domain.model

import com.acmebank.ordermanagementservice.marketdata.Stock

data class SellingPowerKey(
    val customerId: String,
    val stock: Stock,
)

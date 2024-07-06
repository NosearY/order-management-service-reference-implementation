package com.acmebank.ordermanagementservice.sellingpower

data class SellingPowerUpdateCommandApi(
    val customerId: String,
    val symbol: String,
    val quantity: Float,
)

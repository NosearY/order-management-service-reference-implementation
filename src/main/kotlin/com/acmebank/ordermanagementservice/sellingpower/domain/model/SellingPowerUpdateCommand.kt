package com.acmebank.ordermanagementservice.sellingpower.domain.model

data class SellingPowerUpdateCommand(
    val customerId: String,
    val symbol: String,
    val quantity: Float,
)

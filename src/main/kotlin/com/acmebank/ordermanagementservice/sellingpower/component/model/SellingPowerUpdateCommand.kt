package com.acmebank.ordermanagementservice.sellingpower.component.model

data class SellingPowerUpdateCommand(
    val customerId: String,
    val symbol: String,
    val quantity: Float,
)

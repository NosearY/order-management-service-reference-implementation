package com.acmebank.ordermanagementservice.order.feature.dto

import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import java.math.BigDecimal

@Validated
data class CreateOrderRequest(
    @NotNull
    val customerId: String,
    @NotNull
    val orderDirection: String,
    @NotNull
    val symbol: String,
    @NotNull
    val quantity: Float,
    @NotNull
    val priceLimit: BigDecimal,
)

package com.acmebank.ordermanagementservice.order.domain.model

import java.math.BigDecimal
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.pow

data class Order(
    val id: UUID,
    val orderDirection: OrderDirection,
    val referenceNo: String,
    val customerId: String,
    val symbol: String,
    val quantity: Float,
    val priceLimit: BigDecimal,
) {
    companion object {
        private val dateTimeFormatter =
            DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault())
    }

    constructor(
        customerId: String,
        symbol: String,
        quantity: Float,
        priceLimit: BigDecimal,
        orderDirection: OrderDirection,
    ) : this(
        id = UUID.randomUUID(),
        orderDirection = orderDirection,
        referenceNo = "${dateTimeFormatter.format(Instant.now())}_${(Math.random() * 10.0.pow(6.0)).toInt()}",
        customerId = customerId,
        symbol = symbol,
        quantity = quantity,
        priceLimit = priceLimit,
    )
}

enum class OrderDirection { BUY, SELL; }

package com.acmebank.ordermanagementservice.order.domain.model

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.marketdata.Stock
import java.math.BigDecimal
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.UUID
import kotlin.math.pow

data class Order(
    val id: UUID,
    val orderDirection: OrderDirection,
    val referenceNo: String,
    val account: Account,
    val stock: Stock,
    val quantity: Float,
    val priceLimit: BigDecimal,
) {
    companion object {
        private val dateTimeFormatter =
            DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault())
    }

    constructor(
        account: Account,
        symbol: Stock,
        quantity: Float,
        priceLimit: BigDecimal,
        orderDirection: OrderDirection,
    ) : this(
        id = UUID.randomUUID(),
        orderDirection = orderDirection,
        referenceNo = "${dateTimeFormatter.format(Instant.now())}_${(Math.random() * 10.0.pow(6.0)).toInt()}",
        account = account,
        stock = symbol,
        quantity = quantity,
        priceLimit = priceLimit,
    )
}

enum class OrderDirection { BUY, SELL; }

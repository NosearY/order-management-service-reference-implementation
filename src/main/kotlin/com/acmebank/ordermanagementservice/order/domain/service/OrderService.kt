package com.acmebank.ordermanagementservice.order.domain.service

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.repository.OrderRepository
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import java.math.BigDecimal
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

@AllOpen
class OrderService(
    private val orderRepository: OrderRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.systemDefault())

    @Transactional
    fun saveOrder(customerId: String, symbol: String, quantity: Float, priceLimit: BigDecimal) {
        val order = Order(
            id = UUID.randomUUID(),
            referenceNo = "${dateTimeFormatter.format(Instant.now())}_${(Math.random() * 6).toInt()}",
            customerId = customerId,
            symbol = symbol,
            quantity = quantity,
            priceLimit = priceLimit
        )
        orderRepository.saveOrder(order)
        applicationEventPublisher.publishEvent(
            OrderFilledEvent(
                customerId,
                symbol,
                quantity,
                priceLimit
            ).also { logger.info("Published $it") })
    }

}
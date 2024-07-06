package com.acmebank.ordermanagementservice.order.infrastructure

import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.repository.OrderRepository
import java.util.*

class InMemoryOrderRepository(
    private val db: MutableMap<UUID, Order>,
) : OrderRepository {
    override fun createOrder(order: Order) {
        db.computeIfAbsent(order.id) { order }
    }

    override fun listOrders(customerId: String): List<Order> = db.values.filter { it.customerId == customerId }
}

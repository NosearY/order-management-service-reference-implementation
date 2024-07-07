package com.acmebank.ordermanagementservice.order.adapter.inmemory

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.order.component.OrderRepository
import com.acmebank.ordermanagementservice.order.component.model.Order
import java.util.UUID

class InMemoryOrderRepository(
    private val db: MutableMap<UUID, Order>,
) : OrderRepository {
    override fun createOrder(order: Order) {
        db.computeIfAbsent(order.id) { order }
    }

    override fun listOrders(account: Account): List<Order> = db.values.filter { it.account == account }
}

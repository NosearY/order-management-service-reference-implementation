package com.acmebank.ordermanagementservice.order.domain.repository

import com.acmebank.ordermanagementservice.order.domain.model.Order

interface OrderRepository {
    fun createOrder(order: Order)

    fun listOrders(customerId: String): List<Order>
}

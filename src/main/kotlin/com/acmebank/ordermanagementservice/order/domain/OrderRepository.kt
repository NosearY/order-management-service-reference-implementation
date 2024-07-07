package com.acmebank.ordermanagementservice.order.domain

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.order.domain.model.Order

interface OrderRepository {
    fun createOrder(order: Order)

    fun listOrders(account: Account): List<Order>
}

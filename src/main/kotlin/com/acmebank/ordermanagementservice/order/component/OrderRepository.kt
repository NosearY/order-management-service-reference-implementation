package com.acmebank.ordermanagementservice.order.component

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.order.component.model.Order

interface OrderRepository {
    fun createOrder(order: Order)

    fun listOrders(account: Account): List<Order>
}

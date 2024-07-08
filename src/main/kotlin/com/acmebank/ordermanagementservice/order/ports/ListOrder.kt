package com.acmebank.ordermanagementservice.order.ports

import com.acmebank.ordermanagementservice.order.ports.dto.OrderResponse
import org.springframework.http.ResponseEntity

interface ListOrder {
    fun listOrders(customerId: String): ResponseEntity<List<OrderResponse>>
}

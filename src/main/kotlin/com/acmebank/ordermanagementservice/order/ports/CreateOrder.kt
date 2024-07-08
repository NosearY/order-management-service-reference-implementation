package com.acmebank.ordermanagementservice.order.ports

import com.acmebank.ordermanagementservice.order.ports.dto.CreateOrderRequest
import org.springframework.http.ResponseEntity

interface CreateOrder {
    fun createOrder(createOrderRequest: CreateOrderRequest): ResponseEntity<Void>
}

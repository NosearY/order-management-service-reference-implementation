package com.acmebank.ordermanagementservice.order.application.controller

import com.acmebank.ordermanagementservice.order.application.dto.CreateOrderRequest
import com.acmebank.ordermanagementservice.order.domain.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    @Autowired private val orderService: OrderService
) {

    @PostMapping
    fun createOrder(@RequestBody createOrderRequest: CreateOrderRequest): ResponseEntity<Void> {
        with(createOrderRequest) {
            orderService.saveOrder(customerId, symbol, quantity, priceLimit)
        }
        return ResponseEntity.accepted().build()
    }
}
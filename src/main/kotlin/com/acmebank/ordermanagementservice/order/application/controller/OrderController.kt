package com.acmebank.ordermanagementservice.order.application.controller

import com.acmebank.ordermanagementservice.order.application.dto.CreateOrderRequest
import com.acmebank.ordermanagementservice.order.application.dto.OrderResponse
import com.acmebank.ordermanagementservice.order.application.toOrderDTO
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.domain.model.OrderDirection
import com.acmebank.ordermanagementservice.order.domain.service.OrderDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    @Autowired private val orderDomainService: OrderDomainService,
) {
    @PostMapping
    fun createOrder(
        @RequestBody createOrderRequest: CreateOrderRequest,
    ): ResponseEntity<Void> {
        with(createOrderRequest) {
            orderDomainService.saveOrder(
                OrderCreationCommand(
                    customerId,
                    OrderDirection.valueOf(orderDirection),
                    symbol,
                    quantity,
                    priceLimit,
                ),
            )
        }
        return ResponseEntity.accepted().build()
    }

    @GetMapping("/{customerId}")
    fun listOrder(
        @PathVariable customerId: String,
    ): ResponseEntity<List<OrderResponse>> = ResponseEntity.ok(orderDomainService.listOrders(customerId).map { it.toOrderDTO() })
}

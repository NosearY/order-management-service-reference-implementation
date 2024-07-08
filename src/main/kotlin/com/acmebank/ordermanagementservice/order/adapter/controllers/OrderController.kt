package com.acmebank.ordermanagementservice.order.adapter.controllers

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.marketdata.Stock
import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.domain.model.OrderDirection
import com.acmebank.ordermanagementservice.order.domain.service.OrderService
import com.acmebank.ordermanagementservice.order.ports.CreateOrder
import com.acmebank.ordermanagementservice.order.ports.ListOrder
import com.acmebank.ordermanagementservice.order.ports.dto.CreateOrderRequest
import com.acmebank.ordermanagementservice.order.ports.dto.OrderResponse
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
    @Autowired private val orderService: OrderService,
) : CreateOrder,
    ListOrder {
    @PostMapping
    override fun createOrder(
        @RequestBody createOrderRequest: CreateOrderRequest,
    ): ResponseEntity<Void> {
        with(createOrderRequest) {
            orderService.saveOrder(
                OrderCreationCommand(
                    Account(customerId),
                    OrderDirection.valueOf(orderDirection),
                    Stock(symbol),
                    quantity,
                    priceLimit,
                ),
            )
        }
        return ResponseEntity.accepted().build()
    }

    @GetMapping("/{customerId}")
    override fun listOrders(
        @PathVariable customerId: String,
    ): ResponseEntity<List<OrderResponse>> = ResponseEntity.ok(orderService.listOrders(Account(customerId)).map { it.toOrderDTO() })

    private fun Order.toOrderDTO() =
        OrderResponse(
            referenceNo,
            account.customerId,
            stock.symbol,
            quantity,
            priceLimit,
        )
}

package com.acmebank.ordermanagementservice.order.feature

import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.marketdata.Stock
import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.domain.model.OrderDirection
import com.acmebank.ordermanagementservice.order.domain.service.OrderService
import com.acmebank.ordermanagementservice.order.feature.dto.CreateOrderRequest
import com.acmebank.ordermanagementservice.order.feature.dto.OrderResponse
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
) {
    @PostMapping
    fun createOrder(
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
    fun listOrder(
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

package com.acmebank.ordermanagementservice.order.domain.service

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.order.domain.model.Order
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.domain.repository.OrderRepository
import com.acmebank.ordermanagementservice.order.domain.toOrder
import com.acmebank.ordermanagementservice.order.domain.toOrderFilledEvent
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher

@AllOpen
class OrderDomainService(
    private val orderRepository: OrderRepository,
    private val orderValidationService: OrderValidationService,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    @Transactional
    fun saveOrder(orderCreationCommand: OrderCreationCommand) {
        orderValidationService.validateOrderCreation(orderCreationCommand)
        val order = orderCreationCommand.toOrder()
        orderRepository.createOrder(order)
        applicationEventPublisher.publishEvent(order.toOrderFilledEvent())
    }

    fun listOrders(account: Account): List<Order> = orderRepository.listOrders(account)
}

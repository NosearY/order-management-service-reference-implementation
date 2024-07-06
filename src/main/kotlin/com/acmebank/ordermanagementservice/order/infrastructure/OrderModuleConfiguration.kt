package com.acmebank.ordermanagementservice.order.infrastructure

import com.acmebank.ordermanagementservice.order.domain.repository.OrderRepository
import com.acmebank.ordermanagementservice.order.domain.service.OrderService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class OrderModuleConfiguration {

    @Bean
    fun orderRepository() = InMemoryOrderRepository(ConcurrentHashMap())

    @Bean
    fun orderService(orderRepository: OrderRepository, applicationEventPublisher: ApplicationEventPublisher) =
        OrderService(orderRepository, applicationEventPublisher)
}
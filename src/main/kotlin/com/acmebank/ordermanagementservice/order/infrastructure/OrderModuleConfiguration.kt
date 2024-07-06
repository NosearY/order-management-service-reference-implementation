package com.acmebank.ordermanagementservice.order.infrastructure

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import com.acmebank.ordermanagementservice.order.domain.repository.OrderRepository
import com.acmebank.ordermanagementservice.order.domain.service.OrderDomainService
import com.acmebank.ordermanagementservice.order.domain.service.OrderValidationService
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerApiService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class OrderModuleConfiguration {
    @Bean
    fun orderRepository() = InMemoryOrderRepository(ConcurrentHashMap())

    @Bean
    fun orderValidationService(buyingPowerApi: BuyingPowerApiService, sellingPowerApiService: SellingPowerApiService) =
        OrderValidationService(buyingPowerApi, sellingPowerApiService)

    @Bean
    fun orderService(
        orderRepository: OrderRepository,
        orderValidationService: OrderValidationService,
        applicationEventPublisher: ApplicationEventPublisher,
    ) = OrderDomainService(orderRepository, orderValidationService, applicationEventPublisher)
}

package com.acmebank.ordermanagementservice.order.adapter

import com.acmebank.ordermanagementservice.order.adapter.inmemory.InMemoryOrderRepository
import com.acmebank.ordermanagementservice.order.adapter.springevent.SpringBuyingPowerUpdateCommandPublisher
import com.acmebank.ordermanagementservice.order.adapter.springevent.SpringSellingPowerUpdateCommandPublisher
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class OrderModuleConfiguration {
    @Bean
    fun orderRepository() = InMemoryOrderRepository(ConcurrentHashMap())

    @Bean
    fun springSellingPowerUpdateCommandPublisher(applicationEventPublisher: ApplicationEventPublisher) =
        SpringSellingPowerUpdateCommandPublisher(applicationEventPublisher)

    @Bean
    fun springBuyingPowerUpdateCommandPublisher(applicationEventPublisher: ApplicationEventPublisher) =
        SpringBuyingPowerUpdateCommandPublisher(applicationEventPublisher)
}

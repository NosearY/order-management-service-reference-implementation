package com.acmebank.ordermanagementservice.sellingpower.adapter

import com.acmebank.ordermanagementservice.sellingpower.adapter.inmemory.InMemorySellingPowerRepository
import com.acmebank.ordermanagementservice.sellingpower.adapter.springevent.SpringSellingPowerUpdatedEventPublisher
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class SellingPowerModuleConfiguration {
    @Bean
    fun sellingPowerRepository() = InMemorySellingPowerRepository(ConcurrentHashMap())

    @Bean
    fun springSellingPowerUpdatedEventPublisher(applicationEventPublisher: ApplicationEventPublisher) =
        SpringSellingPowerUpdatedEventPublisher(applicationEventPublisher)
}

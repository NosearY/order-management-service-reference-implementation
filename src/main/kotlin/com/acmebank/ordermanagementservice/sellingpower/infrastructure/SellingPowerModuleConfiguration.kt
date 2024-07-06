package com.acmebank.ordermanagementservice.sellingpower.infrastructure

import com.acmebank.ordermanagementservice.sellingpower.application.eventlistener.SellingPowerOrderFilledEventListener
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class SellingPowerModuleConfiguration {
    @Bean
    fun sellingPowerRepository() = InMemorySellingPowerRepository(ConcurrentHashMap())

    @Bean
    fun orderFilledEventListener(sellingPowerRepository: SellingPowerRepository) =
        SellingPowerOrderFilledEventListener(sellingPowerRepository)
}

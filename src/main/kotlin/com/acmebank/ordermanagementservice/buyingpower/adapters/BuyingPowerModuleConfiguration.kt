package com.acmebank.ordermanagementservice.buyingpower.adapters

import com.acmebank.ordermanagementservice.buyingpower.adapters.restclient.CoreBankingRestClient
import com.acmebank.ordermanagementservice.buyingpower.adapters.springevents.SpringBuyingPowerUpdatedEventPublisher
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class BuyingPowerModuleConfiguration {
    @Bean
    fun coreBankingRestClient() = CoreBankingRestClient(ConcurrentHashMap())

    @Bean
    fun springBuyingPowerUpdatedEventPublisher(applicationEventPublisher: ApplicationEventPublisher) =
        SpringBuyingPowerUpdatedEventPublisher(applicationEventPublisher)
}

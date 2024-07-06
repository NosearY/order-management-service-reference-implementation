package com.acmebank.ordermanagementservice.buyingpower.infrastructure

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import com.acmebank.ordermanagementservice.buyingpower.application.eventlistener.BuyingPowerOrderFilledEventListener
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerDomainService
import com.acmebank.ordermanagementservice.buyingpower.infrastructure.restclient.CoreBankingRestClient
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class BuyingPowerModuleConfiguration {
    @Bean
    fun coreBankingRestClient() = CoreBankingRestClient(ConcurrentHashMap())

    @Bean
    fun buyingPowerOrderFilledEventListener(buyingPowerDomainService: BuyingPowerDomainService) =
        BuyingPowerOrderFilledEventListener(buyingPowerDomainService)

    @Bean
    fun buyingPowerDomainService(coreBankingRestClient: CoreBankingRestClient, applicationEventPublisher: ApplicationEventPublisher) =
        BuyingPowerDomainService(coreBankingRestClient, applicationEventPublisher)

    @Bean
    fun buyingPowerApiService(buyingPowerDomainService: BuyingPowerDomainService) = BuyingPowerApiService(buyingPowerDomainService)
}

package com.acmebank.ordermanagementservice.buyingpower.infrastructure

import com.acmebank.ordermanagementservice.buyingpower.application.eventlistener.BuyingPowerCorporateActionEffectiveEventListener
import com.acmebank.ordermanagementservice.buyingpower.application.eventlistener.BuyingPowerUpdateCommandApiListener
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerDomainService
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerUpdateService
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
        BuyingPowerUpdateCommandApiListener(buyingPowerDomainService)

    @Bean
    fun buyingPowerCorporateActionEffectiveEventListener(buyingPowerDomainService: BuyingPowerDomainService) =
        BuyingPowerCorporateActionEffectiveEventListener(buyingPowerDomainService)

    @Bean
    fun buyingPowerDomainService(
        coreBankingRestClient: CoreBankingRestClient,
        applicationEventPublisher: ApplicationEventPublisher,
    ) = BuyingPowerDomainService(coreBankingRestClient, applicationEventPublisher)

    @Bean
    fun buyingPowerUpdateService(coreBankingRestClient: CoreBankingRestClient) = BuyingPowerUpdateService(coreBankingRestClient)
}

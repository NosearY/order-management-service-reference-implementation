package com.acmebank.ordermanagementservice.sellingpower.infrastructure

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerServiceApi
import com.acmebank.ordermanagementservice.sellingpower.application.eventlistener.SellingPowerCorporateActionEffectiveEventListener
import com.acmebank.ordermanagementservice.sellingpower.application.eventlistener.SellingPowerOrderFilledEventListener
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerDomainService
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap

@Configuration
class SellingPowerModuleConfiguration {
    @Bean
    fun sellingPowerRepository() = InMemorySellingPowerRepository(ConcurrentHashMap())

    @Bean
    fun sellingPowerDomainService(
        sellingPowerRepository: SellingPowerRepository,
        applicationEventPublisher: ApplicationEventPublisher,
    ) = SellingPowerDomainService(sellingPowerRepository, applicationEventPublisher)

    @Bean
    fun sellingPowerOrderFilledEventListener(sellingPowerDomainService: SellingPowerDomainService) =
        SellingPowerOrderFilledEventListener(sellingPowerDomainService)

    @Bean
    fun sellingPowerCorporateActionEffectiveEventListener(sellingPowerDomainService: SellingPowerDomainService) =
        SellingPowerCorporateActionEffectiveEventListener(sellingPowerDomainService)

    @Bean
    fun sellingPowerServiceApi() = SellingPowerServiceApi()
}

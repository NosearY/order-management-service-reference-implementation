package com.acmebank.ordermanagementservice.buyingpower.application.eventlistener

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerDomainService
import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

@AllOpen
class BuyingPowerCorporateActionEffectiveEventListener(
    private val buyingPowerDomainService: BuyingPowerDomainService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

package com.acmebank.ordermanagementservice.buyingpower.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.component.service.BuyingPowerService
import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class BuyingPowerCorporateActionEffectiveEventListener(
    private val buyingPowerService: BuyingPowerService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

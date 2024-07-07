package com.acmebank.ordermanagementservice.sellingpower.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import com.acmebank.ordermanagementservice.sellingpower.component.SellingPowerService
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class SellingPowerCorporateActionEffectiveEventListener(
    private val sellingPowerService: SellingPowerService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

package com.acmebank.ordermanagementservice.portfolioanalysis.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import com.acmebank.ordermanagementservice.portfolioanalysis.ports.PortfolioOnCorporateActionEffectiveEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@AllOpen
@Component
class PortfolioAnalysisCorporateActionEffectiveEventListener : PortfolioOnCorporateActionEffectiveEvent {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

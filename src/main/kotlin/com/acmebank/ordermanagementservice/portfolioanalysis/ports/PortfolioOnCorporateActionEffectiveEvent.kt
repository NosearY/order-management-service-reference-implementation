package com.acmebank.ordermanagementservice.portfolioanalysis.ports

import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import org.springframework.modulith.events.ApplicationModuleListener

interface PortfolioOnCorporateActionEffectiveEvent {
    @ApplicationModuleListener
    fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent)
}

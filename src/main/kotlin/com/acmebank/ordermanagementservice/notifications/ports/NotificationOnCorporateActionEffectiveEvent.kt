package com.acmebank.ordermanagementservice.notifications.ports

import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import org.springframework.modulith.events.ApplicationModuleListener

interface NotificationOnCorporateActionEffectiveEvent {
    @ApplicationModuleListener
    fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent)
}

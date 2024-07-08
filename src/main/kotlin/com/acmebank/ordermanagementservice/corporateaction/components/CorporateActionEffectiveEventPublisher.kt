package com.acmebank.ordermanagementservice.corporateaction.components

import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent

interface CorporateActionEffectiveEventPublisher {
    fun publishEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent)
}

package com.acmebank.ordermanagementservice.corporateaction.domain

import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent

interface CorporateActionEffectiveEventPublisher {
    fun publishEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent)
}

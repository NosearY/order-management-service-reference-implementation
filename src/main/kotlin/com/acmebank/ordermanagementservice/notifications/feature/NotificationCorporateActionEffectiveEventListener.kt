package com.acmebank.ordermanagementservice.notifications.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class NotificationCorporateActionEffectiveEventListener {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

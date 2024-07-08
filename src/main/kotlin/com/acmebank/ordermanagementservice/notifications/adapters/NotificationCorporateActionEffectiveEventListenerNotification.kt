package com.acmebank.ordermanagementservice.notifications.adapters

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.corporateaction.CorporateActionEffectiveEvent
import com.acmebank.ordermanagementservice.notifications.ports.NotificationOnCorporateActionEffectiveEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@AllOpen
@Component
class NotificationCorporateActionEffectiveEventListenerNotification : NotificationOnCorporateActionEffectiveEvent {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onCorporateActionEffectiveEvent(corporateActionEffectiveEvent: CorporateActionEffectiveEvent) {
        logger.info("Received $corporateActionEffectiveEvent")
    }
}

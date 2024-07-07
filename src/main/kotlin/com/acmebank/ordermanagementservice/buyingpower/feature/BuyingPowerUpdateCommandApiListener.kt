package com.acmebank.ordermanagementservice.buyingpower.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.buyingpower.component.service.BuyingPowerService
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class BuyingPowerUpdateCommandApiListener(
    private val buyingPowerService: BuyingPowerService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi) {
        logger.info("Received $buyingPowerUpdateCommandApi")
        buyingPowerService.updateBuyingPower(
            buyingPowerUpdateCommandApi.customerId,
            buyingPowerUpdateCommandApi.delta,
        )
    }
}

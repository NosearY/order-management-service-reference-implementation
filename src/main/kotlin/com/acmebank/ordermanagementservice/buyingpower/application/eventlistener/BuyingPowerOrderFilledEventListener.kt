package com.acmebank.ordermanagementservice.buyingpower.application.eventlistener

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerDomainService
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

@AllOpen
class BuyingPowerOrderFilledEventListener(
    private val buyingPowerDomainService: BuyingPowerDomainService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi) {
        logger.info("Received $buyingPowerUpdateCommandApi")

        buyingPowerDomainService.updateBuyingPower(
            BuyingPowerUpdateCommand(
                buyingPowerUpdateCommandApi.customerId,
                buyingPowerUpdateCommandApi.delta
            ),
        )
    }
}

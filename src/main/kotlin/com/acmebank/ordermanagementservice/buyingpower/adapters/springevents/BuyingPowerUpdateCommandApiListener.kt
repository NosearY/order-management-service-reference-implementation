package com.acmebank.ordermanagementservice.buyingpower.adapters.springevents

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerService
import com.acmebank.ordermanagementservice.buyingpower.ports.OnBuyingPowerUpdateCommand
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@AllOpen
@Component
class BuyingPowerUpdateCommandApiListener(
    private val buyingPowerService: BuyingPowerService,
) : OnBuyingPowerUpdateCommand {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onOrderFilledEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi) {
        logger.info("Received $buyingPowerUpdateCommandApi")
        buyingPowerService.updateBuyingPower(
            buyingPowerUpdateCommandApi.customerId,
            buyingPowerUpdateCommandApi.delta,
        )
    }
}

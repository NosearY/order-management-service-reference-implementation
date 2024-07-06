package com.acmebank.ordermanagementservice.sellingpower.application.eventlistener

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerDomainService
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerUpdateCommand
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

@AllOpen
class SellingPowerOrderFilledEventListener(
    private val sellingPowerDomainService: SellingPowerDomainService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onOrderFilledEvent(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi) {
        logger.info("Received $sellingPowerUpdateCommandApi")

        sellingPowerDomainService.updateSellingPower(
            SellingPowerUpdateCommand(
                customerId = sellingPowerUpdateCommandApi.customerId,
                symbol = sellingPowerUpdateCommandApi.symbol,
                quantity = sellingPowerUpdateCommandApi.quantity
            )
        )
    }
}

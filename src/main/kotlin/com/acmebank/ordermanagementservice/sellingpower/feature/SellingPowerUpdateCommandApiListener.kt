package com.acmebank.ordermanagementservice.sellingpower.feature

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerService
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerUpdateCommand
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@AllOpen
@Component
class SellingPowerUpdateCommandApiListener(
    private val sellingPowerService: SellingPowerService,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ApplicationModuleListener
    fun onSellingPowerUpdateCommandApi(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi) {
        logger.info("Received $sellingPowerUpdateCommandApi")

        sellingPowerService.updateSellingPower(
            SellingPowerUpdateCommand(
                customerId = sellingPowerUpdateCommandApi.customerId,
                symbol = sellingPowerUpdateCommandApi.symbol,
                quantity = sellingPowerUpdateCommandApi.quantity,
            ),
        )
    }
}

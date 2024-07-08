package com.acmebank.ordermanagementservice.buyingpower.ports

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi
import org.springframework.modulith.events.ApplicationModuleListener

interface OnBuyingPowerUpdateCommand {
    @ApplicationModuleListener
    fun onOrderFilledEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi)
}

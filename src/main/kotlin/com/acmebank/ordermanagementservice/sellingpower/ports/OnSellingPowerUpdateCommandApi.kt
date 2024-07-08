package com.acmebank.ordermanagementservice.sellingpower.ports

import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi
import org.springframework.modulith.events.ApplicationModuleListener

interface OnSellingPowerUpdateCommandApi {
    @ApplicationModuleListener
    fun onSellingPowerUpdateCommandApi(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi)
}

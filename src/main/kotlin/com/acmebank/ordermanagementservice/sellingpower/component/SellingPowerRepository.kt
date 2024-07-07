package com.acmebank.ordermanagementservice.sellingpower.component

import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerKey
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerUpdateCommand

interface SellingPowerRepository {
    fun updateSellingPower(sellingPowerUpdateCommand: SellingPowerUpdateCommand): SellingPower

    fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower
}

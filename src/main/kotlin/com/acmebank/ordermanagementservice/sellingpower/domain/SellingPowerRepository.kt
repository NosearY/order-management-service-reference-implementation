package com.acmebank.ordermanagementservice.sellingpower.domain

import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerUpdateCommand

interface SellingPowerRepository {
    fun updateSellingPower(sellingPowerUpdateCommand: SellingPowerUpdateCommand): SellingPower

    fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower
}

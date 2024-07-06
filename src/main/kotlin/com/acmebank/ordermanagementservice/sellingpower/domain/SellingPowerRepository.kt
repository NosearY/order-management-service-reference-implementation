package com.acmebank.ordermanagementservice.sellingpower.domain

import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey

interface SellingPowerRepository {

    fun updateSellingPower(orderFilledEvent: OrderFilledEvent)

    fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower
}
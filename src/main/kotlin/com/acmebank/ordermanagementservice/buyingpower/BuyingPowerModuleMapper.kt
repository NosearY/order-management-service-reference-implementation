package com.acmebank.ordermanagementservice.buyingpower

import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPower

fun BuyingPower.toBuyingPowerApi() = BuyingPowerApi(customerId, balance)

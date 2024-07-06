package com.acmebank.ordermanagementservice.buyingpower

import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerDomainService

class BuyingPowerApiService(
    private val buyingPowerDomainService: BuyingPowerDomainService,
) {
    fun getAvailableBuyingPower(customerId: String): BuyingPowerApi =
        buyingPowerDomainService.getAvailableBuyingPower(customerId).toBuyingPowerApi()
}

package com.acmebank.ordermanagementservice.buyingpower

interface BuyingPowerApiService {
    fun getAvailableBuyingPower(customerId: String): BuyingPowerApi
}

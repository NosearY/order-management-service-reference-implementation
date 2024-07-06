package com.acmebank.ordermanagementservice.buyingpower.domain.service

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApi
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPower
import com.acmebank.ordermanagementservice.buyingpower.toBuyingPowerApi

class BuyingPowerUpdateService(
    private val coreBankingBalanceSupplier: CoreBankingBalanceSupplier,
) : BuyingPowerApiService {
    override fun getAvailableBuyingPower(customerId: String): BuyingPowerApi =
        BuyingPower(
            customerId = customerId,
            balance = coreBankingBalanceSupplier.getAvailableBalance(customerId),
        ).toBuyingPowerApi()
}

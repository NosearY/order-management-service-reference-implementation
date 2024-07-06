package com.acmebank.ordermanagementservice.buyingpower.domain.service

import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPower
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand

class BuyingPowerDomainService(
    private val coreBankingBalanceSupplier: CoreBankingBalanceSupplier,
) {
    fun getAvailableBuyingPower(customerId: String): BuyingPower =
        BuyingPower(
            customerId = customerId,
            balance = coreBankingBalanceSupplier.getAvailableBalance(customerId),
        )

    fun updateBuyingPower(buyingPowerUpdateCommand: BuyingPowerUpdateCommand) {
        coreBankingBalanceSupplier.updateAvailableBalance(buyingPowerUpdateCommand)
    }
}

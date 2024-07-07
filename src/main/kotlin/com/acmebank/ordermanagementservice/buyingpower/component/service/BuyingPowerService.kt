package com.acmebank.ordermanagementservice.buyingpower.component.service

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.buyingpower.component.BuyingPowerUpdatedEventPublisher
import com.acmebank.ordermanagementservice.buyingpower.component.CoreBankingBalanceSupplier
import com.acmebank.ordermanagementservice.buyingpower.component.model.BuyingPower
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant

@AllOpen
@Service
class BuyingPowerService(
    private val coreBankingBalanceSupplier: CoreBankingBalanceSupplier,
    private val buyingPowerUpdatedEventPublisher: BuyingPowerUpdatedEventPublisher,
) : BuyingPowerApiService {
    fun updateBuyingPower(
        customerId: String,
        delta: BigDecimal,
    ) {
        val updatedBalance = coreBankingBalanceSupplier.updateAvailableBalance(customerId, delta)
        buyingPowerUpdatedEventPublisher.publishEvent(
            BuyingPowerUpdatedEvent(
                customerId = customerId,
                balance = updatedBalance,
                delta = delta,
                Instant.now(),
            ),
        )
    }

    override fun getAvailableBuyingPower(customerId: String): BigDecimal =
        BuyingPower(
            customerId = customerId,
            balance = coreBankingBalanceSupplier.getAvailableBalance(customerId),
        ).balance
}

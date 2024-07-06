package com.acmebank.ordermanagementservice.buyingpower.domain.service

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPower
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import java.time.Instant

@AllOpen
class BuyingPowerDomainService(
    private val coreBankingBalanceSupplier: CoreBankingBalanceSupplier,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun getAvailableBuyingPower(customerId: String): BuyingPower =
        BuyingPower(
            customerId = customerId,
            balance = coreBankingBalanceSupplier.getAvailableBalance(customerId),
        )

    @Transactional
    fun updateBuyingPower(buyingPowerUpdateCommand: BuyingPowerUpdateCommand) {
        val updatedBalance = coreBankingBalanceSupplier.updateAvailableBalance(buyingPowerUpdateCommand)
        applicationEventPublisher.publishEvent(
            BuyingPowerUpdatedEvent(
                customerId = buyingPowerUpdateCommand.customerId,
                balance = updatedBalance,
                delta = buyingPowerUpdateCommand.delta,
                Instant.now(),
            ),
        )
    }
}

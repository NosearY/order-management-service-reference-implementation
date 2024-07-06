package com.acmebank.ordermanagementservice.buyingpower.domain.service

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import java.time.Instant

@AllOpen
class BuyingPowerDomainService(
    private val coreBankingBalanceSupplier: CoreBankingBalanceSupplier,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
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

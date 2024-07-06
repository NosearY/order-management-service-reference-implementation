package com.acmebank.ordermanagementservice.sellingpower.domain

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerApiService
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerUpdateCommand
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import java.math.BigDecimal
import java.time.Instant

@AllOpen
class SellingPowerDomainService(
    private val sellingPowerRepository: SellingPowerRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) : SellingPowerApiService {

    @Transactional
    fun updateSellingPower(sellingPowerUpdateCommand: SellingPowerUpdateCommand) {
        sellingPowerRepository.updateSellingPower(sellingPowerUpdateCommand).also {
            applicationEventPublisher.publishEvent(
                SellingPowerUpdatedEvent(
                    customerId = sellingPowerUpdateCommand.customerId,
                    symbol = sellingPowerUpdateCommand.symbol,
                    quantity = it.quantity,
                    delta = sellingPowerUpdateCommand.quantity,
                    effectiveTimeStamp = Instant.now(),
                ),
            )
        }
    }

    fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower = sellingPowerRepository.getSellingPower(sellingPowerKey)

    override fun getAvailableSellingPower(customerId: String, symbol: String): BigDecimal {
        return BigDecimal.ZERO
    }
}

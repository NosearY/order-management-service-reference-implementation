package com.acmebank.ordermanagementservice.sellingpower.component

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerApiService
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerKey
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerUpdateCommand
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant

@AllOpen
@Service
class SellingPowerService(
    private val sellingPowerRepository: SellingPowerRepository,
    private val sellingPowerUpdatedEventPublisher: SellingPowerUpdatedEventPublisher,
) : SellingPowerApiService {
    @Transactional
    fun updateSellingPower(sellingPowerUpdateCommand: SellingPowerUpdateCommand) {
        sellingPowerRepository.updateSellingPower(sellingPowerUpdateCommand).also {
            sellingPowerUpdatedEventPublisher.publishEvent(
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

    override fun getAvailableSellingPower(
        customerId: String,
        symbol: String,
    ): BigDecimal = BigDecimal.ZERO
}

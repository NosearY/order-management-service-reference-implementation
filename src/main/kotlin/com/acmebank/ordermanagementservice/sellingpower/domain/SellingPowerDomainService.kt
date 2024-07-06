package com.acmebank.ordermanagementservice.sellingpower.domain

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdatedEvent
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import java.time.Instant


@AllOpen
class SellingPowerDomainService(
    private val sellingPowerRepository: SellingPowerRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    @Transactional
    fun updateSellingPower(orderFilledEvent: OrderFilledEvent) {
        sellingPowerRepository.updateSellingPower(orderFilledEvent).also {
            applicationEventPublisher.publishEvent(
                SellingPowerUpdatedEvent(
                    customerId = orderFilledEvent.customerId,
                    stock = orderFilledEvent.stock,
                    quantity = it.quantity,
                    delta = orderFilledEvent.quantity,
                    effectiveTimeStamp = Instant.now()
                )
            )
        }
    }

    fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower = sellingPowerRepository.getSellingPower(sellingPowerKey)
}

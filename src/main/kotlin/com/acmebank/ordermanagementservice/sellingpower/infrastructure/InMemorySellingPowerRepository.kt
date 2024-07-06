package com.acmebank.ordermanagementservice.sellingpower.infrastructure

import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerRepository
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey

class InMemorySellingPowerRepository(
    private val db: MutableMap<SellingPowerKey, SellingPower>,
) : SellingPowerRepository {
    override fun updateSellingPower(orderFilledEvent: OrderFilledEvent) {
        val sellingPowerKey = SellingPowerKey(orderFilledEvent.customerId, orderFilledEvent.symbol)
        db.compute(sellingPowerKey) { k, v ->
            SellingPower(k, (v?.quantity ?: 0f) + orderFilledEvent.quantity)
        }
    }

    override fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower =
        db.getOrDefault(
            sellingPowerKey,
            SellingPower(sellingPowerKey, 0f),
        )
}

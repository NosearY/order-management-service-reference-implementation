package com.acmebank.ordermanagementservice.sellingpower.infrastructure

import com.acmebank.ordermanagementservice.order.OrderFilledEvent
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerRepository
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey

class InMemorySellingPowerRepository(
    private val db: MutableMap<SellingPowerKey, SellingPower>,
) : SellingPowerRepository {
    override fun updateSellingPower(orderFilledEvent: OrderFilledEvent): SellingPower {
        val sellingPowerKey = SellingPowerKey(orderFilledEvent.customerId, orderFilledEvent.stock)
        return db.compute(sellingPowerKey) { k, v ->
            SellingPower(k, (v?.quantity ?: 0f) + orderFilledEvent.quantity)
        } ?: SellingPower(sellingPowerKey, 0f)
    }

    override fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower =
        db.getOrDefault(
            sellingPowerKey,
            SellingPower(sellingPowerKey, 0f),
        )
}

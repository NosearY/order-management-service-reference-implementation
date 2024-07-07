package com.acmebank.ordermanagementservice.sellingpower.adapter.inmemory

import com.acmebank.ordermanagementservice.sellingpower.component.SellingPowerRepository
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerKey
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerUpdateCommand

class InMemorySellingPowerRepository(
    private val db: MutableMap<SellingPowerKey, SellingPower>,
) : SellingPowerRepository {
    override fun updateSellingPower(sellingPowerUpdateCommand: SellingPowerUpdateCommand): SellingPower {
        val sellingPowerKey = SellingPowerKey(sellingPowerUpdateCommand.customerId, sellingPowerUpdateCommand.symbol)
        return db.compute(sellingPowerKey) { k, v ->
            SellingPower(k, (v?.quantity ?: 0f) + sellingPowerUpdateCommand.quantity)
        } ?: SellingPower(sellingPowerKey, 0f)
    }

    override fun getSellingPower(sellingPowerKey: SellingPowerKey): SellingPower =
        db.getOrDefault(
            sellingPowerKey,
            SellingPower(sellingPowerKey, 0f),
        )
}

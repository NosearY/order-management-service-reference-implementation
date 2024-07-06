package com.acmebank.ordermanagementservice.buyingpower.infrastructure.restclient

import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand
import com.acmebank.ordermanagementservice.buyingpower.domain.service.CoreBankingBalanceSupplier
import java.math.BigDecimal

class CoreBankingRestClient(private val remoteDb: MutableMap<String, BigDecimal>) :
  CoreBankingBalanceSupplier {
  override fun getAvailableBalance(customerId: String): BigDecimal {
    return remoteDb.getOrDefault(customerId, BigDecimal("100"))
  }

  override fun updateAvailableBalance(buyingPowerUpdateCommand: BuyingPowerUpdateCommand) {
    remoteDb.compute(buyingPowerUpdateCommand.customerId) { _, v ->
      (v ?: BigDecimal.ZERO) + buyingPowerUpdateCommand.delta
    }
  }
}

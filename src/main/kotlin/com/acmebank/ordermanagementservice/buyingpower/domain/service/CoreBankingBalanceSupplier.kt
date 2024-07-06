package com.acmebank.ordermanagementservice.buyingpower.domain.service

import com.acmebank.ordermanagementservice.buyingpower.domain.model.BuyingPowerUpdateCommand
import java.math.BigDecimal

interface CoreBankingBalanceSupplier {
  fun getAvailableBalance(customerId: String): BigDecimal

  fun updateAvailableBalance(buyingPowerUpdateCommand: BuyingPowerUpdateCommand)
}

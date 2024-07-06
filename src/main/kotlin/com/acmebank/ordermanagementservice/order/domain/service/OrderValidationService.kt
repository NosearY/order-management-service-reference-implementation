package com.acmebank.ordermanagementservice.order.domain.service

import com.acmebank.ordermanagementservice.InsufficientBuyingPowerExceptions
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.domain.model.OrderDirection
import java.math.BigDecimal

class OrderValidationService(
    private val buyingPowerApiService: BuyingPowerApiService,
) {
    fun validateOrderCreation(orderCreationCommand: OrderCreationCommand) {
        when (orderCreationCommand.orderDirection) {
            OrderDirection.BUY -> validateBuyingPower(orderCreationCommand)
            OrderDirection.SELL -> validateSellingPower(orderCreationCommand)
        }
    }

    private fun validateBuyingPower(orderCreationCommand: OrderCreationCommand) {
        val netAmount = orderCreationCommand.priceLimit * orderCreationCommand.quantity.toBigDecimal()
        val diff = buyingPowerApiService.getAvailableBuyingPower(orderCreationCommand.customerId).balance - netAmount
        if (diff < BigDecimal.ZERO) {
            throw InsufficientBuyingPowerExceptions("Customer balance is insufficient, difference is $diff")
        }
    }

    private fun validateSellingPower(orderCreationCommand: OrderCreationCommand) {
        // TODO
    }
}

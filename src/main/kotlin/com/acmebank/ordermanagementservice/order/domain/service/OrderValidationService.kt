package com.acmebank.ordermanagementservice.order.domain.service

import com.acmebank.ordermanagementservice.InsufficientBuyingPowerExceptions
import com.acmebank.ordermanagementservice.InsufficientSellingPowerExceptions
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import com.acmebank.ordermanagementservice.order.domain.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.domain.model.OrderDirection
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerApiService
import java.math.BigDecimal

class OrderValidationService(
    private val buyingPowerApi: BuyingPowerApiService,
    private val sellingPowerApiService: SellingPowerApiService,
) {
    fun validateOrderCreation(orderCreationCommand: OrderCreationCommand) {
        when (orderCreationCommand.orderDirection) {
            OrderDirection.BUY -> validateBuyingPower(orderCreationCommand)
            OrderDirection.SELL -> validateSellingPower(orderCreationCommand)
        }
    }

    private fun validateBuyingPower(orderCreationCommand: OrderCreationCommand) {
        val netAmount = orderCreationCommand.priceLimit * orderCreationCommand.quantity.toBigDecimal()
        val diff = buyingPowerApi.getAvailableBuyingPower(orderCreationCommand.account.customerId).balance - netAmount
        if (diff < BigDecimal.ZERO) {
            throw InsufficientBuyingPowerExceptions("Customer balance is insufficient, difference is $diff")
        }
    }

    private fun validateSellingPower(orderCreationCommand: OrderCreationCommand) {
        val diff =
            sellingPowerApiService.getAvailableSellingPower(
                orderCreationCommand.account.customerId,
                orderCreationCommand.stock.symbol,
            ) - orderCreationCommand.quantity.toBigDecimal()
        if (diff < BigDecimal.ZERO) {
            throw InsufficientSellingPowerExceptions("Customer balance is insufficient, difference is $diff")
        }
    }
}

package com.acmebank.ordermanagementservice.order.component.service

import com.acmebank.ordermanagementservice.AllOpen
import com.acmebank.ordermanagementservice.account.Account
import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.order.component.BuyingPowerUpdateCommandPublisher
import com.acmebank.ordermanagementservice.order.component.OrderRepository
import com.acmebank.ordermanagementservice.order.component.SellingPowerUpdateCommandPublisher
import com.acmebank.ordermanagementservice.order.component.model.Order
import com.acmebank.ordermanagementservice.order.component.model.OrderCreationCommand
import com.acmebank.ordermanagementservice.order.component.model.OrderDirection
import com.acmebank.ordermanagementservice.order.component.toOrder
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@AllOpen
@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderValidationService: OrderValidationService,
    private val buyingPowerUpdateCommandPublisher: BuyingPowerUpdateCommandPublisher,
    private val sellingPowerUpdateCommandPublisher: SellingPowerUpdateCommandPublisher,
) {
    @Transactional
    fun saveOrder(orderCreationCommand: OrderCreationCommand) {
        orderValidationService.validateOrderCreation(orderCreationCommand)
        val order = orderCreationCommand.toOrder()
        orderRepository.createOrder(order)
        publishAssetsUpdateCommand(orderCreationCommand)
    }

    fun listOrders(account: Account): List<Order> = orderRepository.listOrders(account)

    private fun publishAssetsUpdateCommand(orderCreationCommand: OrderCreationCommand) =
        with(orderCreationCommand) {
            val (cashUpdate, assetUpdate) =
                when (orderDirection) {
                    OrderDirection.BUY -> {
                        priceLimit.times(quantity.toBigDecimal()).negate() to quantity
                    }

                    OrderDirection.SELL -> {
                        priceLimit.times(quantity.toBigDecimal()) to -quantity
                    }
                }
            buyingPowerUpdateCommandPublisher.publishEvent(BuyingPowerUpdateCommandApi(account.customerId, cashUpdate))
            sellingPowerUpdateCommandPublisher.publishEvent(SellingPowerUpdateCommandApi(account.customerId, stock.symbol, assetUpdate))
        }
}

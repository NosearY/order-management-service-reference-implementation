package com.acmebank.ordermanagementservice.order.domain.service

import com.acmebank.ordermanagementservice.order.domain.model.Order

class OrderValidationService {

    fun validateOrder(order: Order) {
        require(order.referenceNo.isNotEmpty())
    }
}
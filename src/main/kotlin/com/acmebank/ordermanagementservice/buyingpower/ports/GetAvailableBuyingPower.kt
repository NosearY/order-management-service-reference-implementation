package com.acmebank.ordermanagementservice.buyingpower.ports

import org.springframework.http.ResponseEntity
import java.math.BigDecimal

interface GetAvailableBuyingPower {
    fun getAvailableBuyingPower(customerId: String): ResponseEntity<BigDecimal>
}

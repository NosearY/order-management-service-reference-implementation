package com.acmebank.ordermanagementservice.sellingpower.ports

import com.acmebank.ordermanagementservice.sellingpower.adapter.controllers.dto.SellingPowerResponse
import org.springframework.http.ResponseEntity

interface GetSellingPower {
    fun getSellingPower(
        customerId: String,
        symbol: String,
    ): ResponseEntity<SellingPowerResponse>
}

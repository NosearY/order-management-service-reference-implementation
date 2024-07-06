package com.acmebank.ordermanagementservice.sellingpower.application.controller

import com.acmebank.ordermanagementservice.marketdata.Stock
import com.acmebank.ordermanagementservice.sellingpower.application.dto.SellingPowerResponse
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerDomainService
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.domain.model.SellingPowerKey
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/selling-powers")
class SellingPowerController(
    private val sellingPowerDomainService: SellingPowerDomainService,
) {
    @GetMapping("/{customerId}/{symbol}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getSellingPower(
        @PathVariable customerId: String,
        @PathVariable symbol: String,
    ): ResponseEntity<SellingPowerResponse> =
        ResponseEntity.ok(
            sellingPowerDomainService.getSellingPower(SellingPowerKey(customerId, Stock(symbol))).toSellingPowerResponse(),
        )

    private fun SellingPower.toSellingPowerResponse() =
        SellingPowerResponse(
            symbol = sellingPowerKey.stock.symbol,
            quantity = quantity,
        )
}

package com.acmebank.ordermanagementservice.sellingpower.application.controller

import com.acmebank.ordermanagementservice.sellingpower.application.dto.SellingPowerResponse
import com.acmebank.ordermanagementservice.sellingpower.domain.SellingPowerRepository
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
    private val sellingPowerRepository: SellingPowerRepository
) {


    @GetMapping("/{customerId}/{symbol}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getSellingPower(
        @PathVariable customerId: String,
        @PathVariable symbol: String
    ): ResponseEntity<SellingPowerResponse> {
        return ResponseEntity.ok(
            sellingPowerRepository.getSellingPower(SellingPowerKey(customerId, symbol)).toSellingPowerResponse()
        )
    }

    private fun SellingPower.toSellingPowerResponse() =
        SellingPowerResponse(
            symbol = sellingPowerKey.symbol,
            quantity = quantity
        )
}
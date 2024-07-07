package com.acmebank.ordermanagementservice.sellingpower.feature

import com.acmebank.ordermanagementservice.sellingpower.component.SellingPowerService
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPower
import com.acmebank.ordermanagementservice.sellingpower.component.model.SellingPowerKey
import com.acmebank.ordermanagementservice.sellingpower.feature.dto.SellingPowerResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/selling-powers")
class SellingPowerController(
    private val sellingPowerService: SellingPowerService,
) {
    @GetMapping("/{customerId}/{symbol}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getSellingPower(
        @PathVariable customerId: String,
        @PathVariable symbol: String,
    ): ResponseEntity<SellingPowerResponse> =
        ResponseEntity.ok(
            sellingPowerService.getSellingPower(SellingPowerKey(customerId, symbol)).toSellingPowerResponse(),
        )

    private fun SellingPower.toSellingPowerResponse() =
        SellingPowerResponse(
            symbol = sellingPowerKey.symbol,
            quantity = quantity,
        )
}

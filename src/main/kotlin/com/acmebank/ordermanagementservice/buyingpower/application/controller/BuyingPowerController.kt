package com.acmebank.ordermanagementservice.buyingpower.application.controller

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerApiService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/buying-powers")
class BuyingPowerController(
    private val buyingPowerApiService: BuyingPowerApiService,
) {
    
    @GetMapping("/{customerId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBuyingPower(
        @PathVariable customerId: String,
    ): ResponseEntity<BigDecimal> =
        ResponseEntity.ok(
            buyingPowerApiService.getAvailableBuyingPower(customerId).balance,
        )
}

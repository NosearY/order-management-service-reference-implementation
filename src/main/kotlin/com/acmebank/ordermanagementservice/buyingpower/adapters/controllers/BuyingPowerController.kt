package com.acmebank.ordermanagementservice.buyingpower.adapters.controllers

import com.acmebank.ordermanagementservice.buyingpower.domain.service.BuyingPowerService
import com.acmebank.ordermanagementservice.buyingpower.ports.GetAvailableBuyingPower
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
    private val buyingPowerService: BuyingPowerService,
) : GetAvailableBuyingPower {
    @GetMapping("/{customerId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun getAvailableBuyingPower(
        @PathVariable customerId: String,
    ): ResponseEntity<BigDecimal> =
        ResponseEntity.ok(
            buyingPowerService.getAvailableBuyingPower(customerId),
        )
}

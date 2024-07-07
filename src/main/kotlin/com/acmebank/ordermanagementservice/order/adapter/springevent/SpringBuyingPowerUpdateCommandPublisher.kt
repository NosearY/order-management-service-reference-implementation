package com.acmebank.ordermanagementservice.order.adapter.springevent

import com.acmebank.ordermanagementservice.buyingpower.BuyingPowerUpdateCommandApi
import com.acmebank.ordermanagementservice.order.component.BuyingPowerUpdateCommandPublisher
import org.springframework.context.ApplicationEventPublisher

class SpringBuyingPowerUpdateCommandPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : BuyingPowerUpdateCommandPublisher {
    override fun publishEvent(buyingPowerUpdateCommandApi: BuyingPowerUpdateCommandApi) {
        applicationEventPublisher.publishEvent(buyingPowerUpdateCommandApi)
    }
}

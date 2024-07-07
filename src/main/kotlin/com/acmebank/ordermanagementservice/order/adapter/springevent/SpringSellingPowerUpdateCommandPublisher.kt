package com.acmebank.ordermanagementservice.order.adapter.springevent

import com.acmebank.ordermanagementservice.order.component.SellingPowerUpdateCommandPublisher
import com.acmebank.ordermanagementservice.sellingpower.SellingPowerUpdateCommandApi
import org.springframework.context.ApplicationEventPublisher

class SpringSellingPowerUpdateCommandPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : SellingPowerUpdateCommandPublisher {
    override fun publishEvent(sellingPowerUpdateCommandApi: SellingPowerUpdateCommandApi) {
        applicationEventPublisher.publishEvent(sellingPowerUpdateCommandApi)
    }
}

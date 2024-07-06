package com.acmebank.ordermanagementservice.notifications.infrastructure

import com.acmebank.ordermanagementservice.notifications.application.NotificationAnalysisSellingPowerUpdatedEventListener
import com.acmebank.ordermanagementservice.notifications.application.NotificationBuyingPowerUpdatedEventListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotificationModuleConfiguration {
    @Bean
    fun notificationBuyingPowerUpdatedEventListener() = NotificationBuyingPowerUpdatedEventListener()

    @Bean
    fun notificationAnalysisSellingPowerUpdatedEventListener() = NotificationAnalysisSellingPowerUpdatedEventListener()
}

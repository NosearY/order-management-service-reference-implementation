package com.acmebank.ordermanagementservice.portfolioanalysis.infrastructure

import com.acmebank.ordermanagementservice.portfolioanalysis.application.PortfolioAnalysisBuyingPowerUpdatedEventListener
import com.acmebank.ordermanagementservice.portfolioanalysis.application.PortfolioAnalysisSellingPowerUpdatedEventListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PortfolioAnalysisModuleConfiguration {

    @Bean
    fun portfolioAnalysisBuyingPowerUpdatedEventListener() = PortfolioAnalysisBuyingPowerUpdatedEventListener()

    @Bean
    fun portfolioAnalysisSellingPowerUpdatedEventListener() = PortfolioAnalysisSellingPowerUpdatedEventListener()

}

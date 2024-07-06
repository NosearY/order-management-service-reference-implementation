package com.acmebank.ordermanagementservice

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.modulith.core.ApplicationModules

class ArchitectureTest {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Test
    fun verifiesModularStructure() {
        val modules = ApplicationModules.of(OrderManagementServiceApplication::class.java)
        modules.forEach { logger.info(it.toString()) }
        modules.verify()
    }
}

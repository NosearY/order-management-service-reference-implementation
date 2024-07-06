package com.acmebank.ordermanagementservice

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules

class ArchitectureTest {
    @Test
    fun verifiesModularStructure() {
        val modules = ApplicationModules.of(OrderManagementServiceApplication::class.java)
        modules.verify()
    }
}

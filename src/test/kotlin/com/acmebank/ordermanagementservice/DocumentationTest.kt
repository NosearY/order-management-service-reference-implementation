package com.acmebank.ordermanagementservice

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

class DocumentationTest {

    private val modules = ApplicationModules.of(OrderManagementServiceApplication::class.java)

    @Test
    fun writeDocumentationSnippets() {
        Documenter(modules)
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml()
            .writeModuleCanvases()
    }

}

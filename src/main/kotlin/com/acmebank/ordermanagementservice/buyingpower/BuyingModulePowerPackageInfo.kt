package com.acmebank.ordermanagementservice.buyingpower

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.PackageInfo

@PackageInfo
@ApplicationModule(allowedDependencies = ["order", "corporateaction"])
class BuyingModulePowerPackageInfo

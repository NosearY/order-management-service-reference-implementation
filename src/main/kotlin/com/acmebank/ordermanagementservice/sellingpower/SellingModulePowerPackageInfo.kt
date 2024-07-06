package com.acmebank.ordermanagementservice.sellingpower

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.PackageInfo

@PackageInfo
@ApplicationModule(allowedDependencies = ["order", "corporateaction"])
class SellingModulePowerPackageInfo

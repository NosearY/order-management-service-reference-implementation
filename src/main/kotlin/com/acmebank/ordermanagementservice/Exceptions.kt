package com.acmebank.ordermanagementservice

class InsufficientBuyingPowerExceptions(
    message: String,
) : RuntimeException(
        message,
    )

class InsufficientSellingPowerExceptions(
    message: String,
) : RuntimeException(
        message,
    )

package com.acmebank.ordermanagementservice

class InsufficientBuyingPowerExceptions(
    message: String,
) : RuntimeException(
        message,
    )

class OtherExceptions(
    message: String,
) : RuntimeException(
        message,
    )

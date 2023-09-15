package com.corcaai.adcio_core.error

data class IsNeedClientIdException(
    override val message: String
) : RuntimeException()

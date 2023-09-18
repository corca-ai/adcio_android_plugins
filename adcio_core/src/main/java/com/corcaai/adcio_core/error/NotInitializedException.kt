package com.corcaai.adcio_core.error

data class NotInitializedException(
    override val message: String
) : RuntimeException()

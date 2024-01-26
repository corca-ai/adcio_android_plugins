package com.corcaai.adcio_core.error

data class NotInitializedException(
    override val message: String = "You must call init before using the core."
) : RuntimeException()

package com.corcaai

import com.corcaai.adcio_core.error.NotInitializedException
import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.Assert.assertEquals
import org.junit.Test

class AdcioCoreUnitTest {
    @Test(expected = NotInitializedException::class)
    fun testNotInitialized() {
        val clientId = AdcioCore.clientId
    }

    @Test
    fun testInitialization() {
        AdcioCore.init("testId")
        assertEquals("testId", AdcioCore.clientId)
    }
}

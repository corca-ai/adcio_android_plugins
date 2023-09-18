package com.corcaai

import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.Assert.assertEquals
import org.junit.Test

class AdcioCoreUnitTest {

    // Calling the client ID after init from a simple external class, not the Android area
    @Test
    fun testInitialization() {
        AdcioCore.init("testId")
        assertEquals("testId", AdcioCore.clientId)
    }
}

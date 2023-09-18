package com.corcaai

import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.Assert.assertEquals
import org.junit.Test

class AdcioCoreUnitTest {

    @Test
    fun testInitialization() {
        AdcioCore.init("testId")
        assertEquals("testId", AdcioCore.clientId)
    }
}

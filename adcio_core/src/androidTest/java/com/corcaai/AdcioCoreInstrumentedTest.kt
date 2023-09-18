package com.corcaai

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class AdcioCoreInstrumentedTest {

    @Test
    fun testNotInitialized() {
        val exception = assertThrows(NotInitializedException::class.java) {
            AdcioCore.clientId
        }
        assertEquals("You must call init before using the core.", exception.message)
    }

    @After
    fun testInitialization() {
        AdcioCore.init("clientId")
        assertEquals("clientId", AdcioCore.clientId)

        assert(AdcioCore.sessionId.isNotBlank())

        assertEquals(Build.ID, AdcioCore.deviceId)

        assertEquals(AdcioCore.clientId, AdcioCore.storeId)
    }
}

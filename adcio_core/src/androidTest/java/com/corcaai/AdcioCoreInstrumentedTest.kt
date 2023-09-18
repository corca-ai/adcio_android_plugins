package com.corcaai

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class AdcioCoreInstrumentedTest {

    /**
     * A test that raises a NotInitalizedException by accessing the clientId before init.
     */
    @Test
    fun testNotInitialized() {
        val exception = assertThrows(NotInitializedException::class.java) {
            AdcioCore.clientId
        }
        assertEquals("You must call init before using the core.", exception.message)
    }

    /**
     * Test to see whether the id is properly created when calling the value after init and whether it is maintained during the life cycle of the app.
     */
    @After
    fun testInitialization() {
        AdcioCore.init("clientId")
        assertEquals("clientId", AdcioCore.clientId)

        assert(AdcioCore.sessionId.isNotBlank())

        assertEquals(Build.ID, AdcioCore.deviceId)

        assertEquals(AdcioCore.clientId, AdcioCore.storeId)
    }
}

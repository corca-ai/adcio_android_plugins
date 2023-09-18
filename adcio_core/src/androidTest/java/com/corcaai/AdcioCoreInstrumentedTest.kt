package com.corcaai

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.corcaai.adcio_core.error.NotInitializedException
import com.corcaai.adcio_core.feature.AdcioCore
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AdcioCoreInstrumentedTest {
    @Test(expected = NotInitializedException::class)
    fun testNotInitialized() {
        val clientId = AdcioCore.clientId
    }

    @Test
    fun testInitialization() {
        AdcioCore.init("clientId")
        assertEquals("clientId", AdcioCore.clientId)

        assert(AdcioCore.sessionId.isNotBlank())

        assertEquals(Build.ID, AdcioCore.deviceId)

        assertEquals(AdcioCore.clientId, AdcioCore.storeId)
    }
}

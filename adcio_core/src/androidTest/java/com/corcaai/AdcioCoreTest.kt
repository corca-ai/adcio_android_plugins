package com.corcaai

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import com.corcaai.adcio_core.feature.AdcioCore
import org.jetbrains.annotations.TestOnly
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class AdcioCoreTest {

    companion object {
        const val EXCEPTION_MESSAGE = "You must call init before using the core."
    }

    @Before
    fun testIdNotInitialized() {
        testClientIdNotInitialized()
        testSessionIdNotInitialized()
        testDeviceIdNotInitialized()
        testStoreIdNotInitialized()
    }

    /**
     * A test that raises a NotInitializedException by accessing the clientId before init.
     */
    @TestOnly
    fun testClientIdNotInitialized() {
        val exception = assertThrows(NotInitializedException::class.java) {
            AdcioCore.clientId
        }
        assertEquals(EXCEPTION_MESSAGE, exception.message)
    }

    /**
     * A test that raises a NotInitializedException by accessing the storeId before init.
     */
    @TestOnly
    fun testStoreIdNotInitialized() {
        val exception = assertThrows(NotInitializedException::class.java) {
            AdcioCore.storeId
        }
        assertEquals(EXCEPTION_MESSAGE, exception.message)
    }

    /**
     * A test that raises a NotInitializedException by accessing the sessionId before init.
     */
    @TestOnly
    fun testSessionIdNotInitialized() {
        val setterException = assertThrows(NotInitializedException::class.java) {
            AdcioCore.sessionId = ""
        }
        val getterException = assertThrows(NotInitializedException::class.java) {
            AdcioCore.sessionId
        }
        assertEquals(setterException.message, getterException.message)
    }

    /**
     * A test that raises a NotInitializedException by accessing the deviceId before init.
     */
    @TestOnly
    fun testDeviceIdNotInitialized() {
        val setterException = assertThrows(NotInitializedException::class.java) {
            AdcioCore.deviceId = ""
        }
        val getterException = assertThrows(NotInitializedException::class.java) {
            AdcioCore.deviceId
        }
        assertEquals(setterException.message, getterException.message)
    }

    @Test
    fun testCoreIdCreation() {
        AdcioCore.initializeApp("clientId")

        testClientIdCreation()
        testSessionIdCreation()
        testDeviceIdCreation()
        testStoreIdCreation()
    }

    @TestOnly
    fun testClientIdCreation() {
        assertEquals("clientId", AdcioCore.clientId)
    }

    @TestOnly
    fun testStoreIdCreation() {
        assertEquals(AdcioCore.clientId, AdcioCore.storeId)
    }

    @TestOnly
    fun testSessionIdCreation() {
        assert(AdcioCore.sessionId != "")
    }

    @TestOnly
    fun testDeviceIdCreation() {
        assertEquals(Build.ID, AdcioCore.deviceId)
    }

    @After
    fun testIdValuePreservation() {
        AdcioCore.initializeApp("")

        testDeviceIdValuePreservation()
        testSessionIdValuePreservation()
        testAfterAgainInitSessionIdValuePreservation()
    }

    @TestOnly
    fun testDeviceIdValuePreservation() {
        val oldDeviceId = AdcioCore.deviceId
        Thread.sleep(1000)
        val newDeviceId = AdcioCore.deviceId

        assertEquals(oldDeviceId, newDeviceId)
    }

    @TestOnly
    fun testSessionIdValuePreservation() {
        val oldSessionId = AdcioCore.sessionId
        Thread.sleep(1000)
        val newSessionId = AdcioCore.sessionId

        assertEquals(oldSessionId, newSessionId)
    }

    @TestOnly
    fun testAfterAgainInitSessionIdValuePreservation() {
        val oldSessionId = AdcioCore.sessionId
        AdcioCore.initializeApp("")
        val newSessionId = AdcioCore.sessionId

        assertEquals(oldSessionId, newSessionId)
    }
}

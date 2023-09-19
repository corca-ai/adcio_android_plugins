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
     * A test that raises a NotInitializedException by accessing the sessionId before init.
     */
    @TestOnly
    fun testSessionIdNotInitialized() {
        val exception = assertThrows(NotInitializedException::class.java) {
            AdcioCore.sessionId
        }
        assertEquals(EXCEPTION_MESSAGE, exception.message)
    }

    /**
     * A test that raises a NotInitializedException by accessing the deviceId before init.
     */
    @TestOnly
    fun testDeviceIdNotInitialized() {
        val exception = assertThrows(NotInitializedException::class.java) {
            AdcioCore.deviceId
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

    @Test
    fun testCoreIdCreation() {
        AdcioCore.init("clientId")

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
    fun testSessionIdCreation() {
        assert(AdcioCore.sessionId != "")
    }

    @TestOnly
    fun testDeviceIdCreation() {
        assertEquals(Build.ID, AdcioCore.deviceId)
    }

    @TestOnly
    fun testStoreIdCreation() {
        assertEquals(AdcioCore.clientId, AdcioCore.storeId)
    }

    @After
    fun testIdValuePreservation() {
        AdcioCore.init("")

        testDeviceIdValuePreservation()
        testSessionIdValuePreservation()
    }

    @TestOnly
    fun testDeviceIdValuePreservation() {
        val deviceId1 = AdcioCore.deviceId
        Thread.sleep(1000)
        val deviceId2 = AdcioCore.deviceId

        assertEquals(deviceId1, deviceId2)
    }

    @TestOnly
    fun testSessionIdValuePreservation() {
        val sessionId1 = AdcioCore.sessionId
        Thread.sleep(1000)
        val sessionId2 = AdcioCore.sessionId

        assertEquals(sessionId1, sessionId2)
    }
}

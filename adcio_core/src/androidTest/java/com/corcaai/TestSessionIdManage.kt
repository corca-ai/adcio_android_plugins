package com.corcaai

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.corcaai.adcio_core.feature.AdcioInfo
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestSessionIdManage {
    private lateinit var appContext: Context

    @Before
    fun setup() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    }

    @Test
    fun testIsSessionIdMatch() {
        val sessionId1 = AdcioInfo.sessionId

        Thread.sleep(1000)

        val sessionId2 = AdcioInfo.sessionId

        assertEquals("Session ID values do not match", sessionId1, sessionId2)
    }
}

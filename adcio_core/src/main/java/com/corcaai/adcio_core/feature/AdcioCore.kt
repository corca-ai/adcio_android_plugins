package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import java.util.UUID

object AdcioCore {

    private var isInitialized: Boolean = false
    private var sessionIdValue: String? = null

    fun initializeApp(id: String) {
        isInitialized = true
        clientId = id
    }

    /**
     * You can obtain the clientId registered.
     */
    var clientId: String = ""
        private set
        get() {
            if (!isInitialized) throw NotInitializedException()
            return field
        }

    /**
     * You can obtain the storeId registered.
     */
    var storeId: String? = null
        private set
        get() {
            if (!isInitialized) throw NotInitializedException()
            return clientId
        }

    /**
     * You can obtain the sessionId registered.
     */
     var sessionId: String
        set(value) {
            if (!isInitialized) throw NotInitializedException()
            sessionIdValue = value
        }
        get() {
            if (!isInitialized) throw NotInitializedException()

            // Generate a new session ID if it's not already generated
            sessionIdValue = sessionIdValue ?: UUID.randomUUID().toString()
            return sessionIdValue!!
        }

    /**
     * You can obtain the deviceId registered.
     */
    var deviceId: String = ""
        set(value) {
            if (!isInitialized) throw NotInitializedException()
            field = value
        }
        get() {
            if (!isInitialized) throw NotInitializedException()
            // Generate and return device id
            return field.takeIf { it.isNotBlank() } ?: Build.ID
        }
}

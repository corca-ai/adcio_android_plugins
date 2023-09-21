package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import java.util.UUID

object AdcioCore {

    private var isInitialized: Boolean = false
    private var sessionIdValue: String? = null

    fun initializeApp(id: String) {
        clientId = id
        isInitialized = true
    }

    /**
     * You can obtain the clientId registered.
     */
    private var clientId: String = ""

    fun getClientId(): String {
        if (!isInitialized) throw NotInitializedException()
        return clientId
    }

    fun getStoreId(): String {
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

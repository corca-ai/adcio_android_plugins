package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import java.util.UUID

object AdcioCore {

    private var isInitialized: Boolean = false

    fun initializeApp(id: String) {
        clientId = id
        isInitialized = true
    }

    /**
     * You can obtain the clientId registered.
     */
    var clientId: String = ""
        get() {
            if (!isInitialized) throw NotInitializedException()

            // Returns the clientId you entered during init
            return field
        }

    private var sessionIdValue: String? = null

    /**
     * You can obtain the sessionId registered.
     */
    var sessionId: String
        set(value) {
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
        get() {
            if (!isInitialized) throw NotInitializedException()
            // Generate and return device id
            return field.takeIf { it.isNotBlank() } ?: Build.ID
        }

    /**
     * You can obtain the storeId registered.
     */
    var storeId: String? = null
        get() {
            if (!isInitialized) throw NotInitializedException()
            // If empty, returns clientId
            return field ?: clientId
        }
}

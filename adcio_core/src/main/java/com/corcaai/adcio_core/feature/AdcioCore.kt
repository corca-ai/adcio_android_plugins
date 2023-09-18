package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import java.util.UUID

object AdcioCore {

    private var isInitialized: Boolean = false

    fun init(id: String) {
        clientId = id
        isInitialized = true
    }

    var clientId: String = ""
        get() {
            if (!isInitialized) throw NotInitializedException()
            return field
        }

    private var sessionIdValue: String? = null

    var sessionId: String = ""
        get() {
            if (!isInitialized) throw NotInitializedException()

            // Generate a new session ID if it's not already generated
            sessionIdValue = sessionIdValue ?: UUID.randomUUID().toString()
            return sessionIdValue!!
        }

    var deviceId: String = ""
        get() {
            if (!isInitialized) throw NotInitializedException()
            return field.takeIf { it.isNotBlank() } ?: Build.ID
        }

    /**
     * You can obtain the storeId registered.
     */
    var storeId: String? = null
        get() {
            if (!isInitialized) throw NotInitializedException()
            else return field ?: clientId
        }
}

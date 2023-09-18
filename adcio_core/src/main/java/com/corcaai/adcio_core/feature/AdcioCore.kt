package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.NotInitializedException
import java.util.UUID

object AdcioCore {
    private var isInitialized: Boolean = false
    private var sessionIdValue: String? = null
    private const val notInitializedComment: String = "You must call init before using the core."
    fun init(id: String) {
        clientId = id
        this.isInitialized = true
    }

    var clientId: String = ""
        get() {
            if (isInitialized) return field
            else throw NotInitializedException(notInitializedComment)
        }

    /**
     * You can obtain the sessionId registered.
     */
    var sessionId: String = ""
        get() {
            if (isInitialized) {
                if (sessionIdValue == null) {
                    sessionIdValue = UUID.randomUUID().toString()
                }
                return sessionIdValue!!
            } else throw NotInitializedException(notInitializedComment)
        }

    /**
     * You can obtain the deviceId registered.
     */
    var deviceId: String? = null
        get() {
            if (isInitialized) {
                return field ?: Build.ID
            } else throw NotInitializedException(notInitializedComment)
        }

    /**
     * You can obtain the storeId registered.
     */
    var storeId: String? = null
        get() {
            if(isInitialized) {
                return field ?: clientId
            } else throw NotInitializedException(notInitializedComment)
        }
}

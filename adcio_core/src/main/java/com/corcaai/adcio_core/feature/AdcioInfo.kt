package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.IsNeedClientIdException
import java.util.UUID

object AdcioInfo {
    private var isInitialized: Boolean = false

    fun init(id: String) {
        clientId = id
        this.isInitialized = true
    }

    var clientId: String = ""
        get() {
            if (isInitialized) return field
            else throw IsNeedClientIdException("This function requests the init task to use the clientId or storeId.")
        }

    /**
     * You can obtain the sessionId registered.
     */
    var sessionId: String? = null
        get() {
            return field ?: UUID.randomUUID().toString()
        }

    /**
     * You can obtain the deviceId registered.
     */
    var deviceId: String? = null
        get() {
            return field ?: Build.ID
        }

    /**
     * You can obtain the storeId registered.
     */
    var storeId: String? = null
        get() {
            return field ?: clientId
        }
}

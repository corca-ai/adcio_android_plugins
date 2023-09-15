package com.corcaai.adcio_core.feature

import android.os.Build
import com.corcaai.adcio_core.error.IsNeedClientIdException
import java.util.UUID

object AdcioInfo {
    private var sessionId: String? = null
    private var deviceId: String? = null
    private var clientId: String = ""

    private var isInitialized: Boolean = false

    fun init(id: String) {
        clientId = id
        this.isInitialized = true
    }

    /**
     * You can obtain the client registered.
     * You can get back the clientId you passed when first initing.
     */
    fun getClientId(): String {
        if (isInitialized) {
            return clientId
        } else throw IsNeedClientIdException("This function requests the init task to use the clientID.")
    }

    /**
     * You can obtain the sessionId registered.
     */
    fun getSessionId(): String {
        sessionId?.let {
            sessionId = UUID.randomUUID().toString()
        }
        return sessionId ?: UUID.randomUUID().toString()
    }

    /**
     * You can obtain the deviceId registered.
     */
    fun getDeviceId(): String {
        deviceId?.let {
            deviceId = Build.ID
        }
        return deviceId ?: Build.ID
    }
}

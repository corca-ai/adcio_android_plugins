package ai.corca.adcio_placement.feature

import android.os.Build
import java.util.UUID

class AdcioSuggestionInfo {
    private var sessionId: String? = null
    private var deviceId: String? = null

    fun getSessionId(): String {
        sessionId?.let {
            sessionId = UUID.randomUUID().toString()
        }
        return sessionId ?: UUID.randomUUID().toString()
    }

    fun getDeviceId(): String {
        deviceId?.let {
            deviceId = Build.ID
        }
        return deviceId ?: Build.ID
    }
}

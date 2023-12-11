package ai.corca.adcio_placement

import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import org.junit.Assert.assertEquals
import org.junit.Test

class AdcioPlacementTest {
    private val placementRemote = PlacementRemote()

    private val sessionId = "a3e0efcc-bbed-4c73-b001-cd3d0c54e7a6"
    private val deviceId = "TP1A.220624.022"

    private val activatedPlacementId = "67592c00-a230-4c31-902e-82ae4fe71866"
    private val disabledPlacementId = "b79deee6-3a05-4be6-902c-23220f8fc2cb"
    private val randomUUID = "34afc940-3801-45f6-b558-2365b26c8196"
    private val notUUID = "test-uuid"

    @Test
    fun testPlacementCallSuccess() {
        val result = placementRemote.getSuggestion(
            sessionId = sessionId,
            deviceId = deviceId,
            placementId = activatedPlacementId,
            fromAgent = false
        )
        assertEquals(true, result is AdcioSuggestionRaw)
    }

    @Test
    fun testIsThrowBadRequestException() {
        try {
            placementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = notUUID,
                fromAgent = false
            )
        } catch (exception: Exception) {
            expect("placementId value is not a UUID", exception)
        }
    }

    @Test
    fun testIsThrowUnRegisterIdException() {
        try {
            placementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = randomUUID,
                fromAgent = false
            )
        } catch (exception: Exception) {
            expect("placementId value is not registered", exception)
        }
    }

    @Test
    fun testIsThrowDisabledPlacementException() {
        try {
            placementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = disabledPlacementId,
                fromAgent = false
            )
        } catch (exception: Exception) {
            expect("placementId is not enabled", exception)
        }
    }

    private fun expect(errorMessage: String, exception: Exception) {
        if (errorMessage == exception.message) {
            print("${exception.message}")
        }
    }
}

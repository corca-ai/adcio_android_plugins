package ai.corca.adcio_placement

import ai.corca.adcio_placement.exception.BadRequestException
import ai.corca.adcio_placement.exception.DisabledPlacementException
import ai.corca.adcio_placement.exception.UnregisteredIdException
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import ai.corca.adcio_placement.network.remote.PlacementRemote
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AdcioPlacementTest {

    private val sessionId = "a3e0efcc-bbed-4c73-b001-cd3d0c54e7a6"
    private val deviceId = "TP1A.220624.022"

    private val activatedPlacementId = "67592c00-a230-4c31-902e-82ae4fe71866"
    private val disabledPlacementId = "b79deee6-3a05-4be6-902c-23220f8fc2cb"
    private val randomUUID = "34afc940-3801-45f6-b558-2365b26c8196"
    private val notUUID = "test-uuid"

    @Test
    fun testPlacementCallSuccess() {
        val mockPlacementRemote = mockk<PlacementRemote>()
        val expectedResult = AdcioSuggestionRaw::class.java

        every {
            mockPlacementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = activatedPlacementId,
                fromAgent = false
            )
        } answers {
            expectedResult.newInstance()
        }
    }

    @Test
    fun testIsThrowBadRequestException() {
        val mockPlacementRemote = mockk<PlacementRemote>()

        every {
            mockPlacementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = notUUID,
                fromAgent = false
            )
        }.throws(BadRequestException())
    }

    @Test
    fun testIsThrowUnRegisterIdException() {
        val mockPlacementRemote = mockk<PlacementRemote>()

        every {
            mockPlacementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = randomUUID,
                fromAgent = false
            )
        }.throws(UnregisteredIdException())
    }

    @Test
    fun testIsThrowDisabledPlacementException() {
        val mockPlacementRemote = mockk<PlacementRemote>()

        every {
            mockPlacementRemote.getSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = disabledPlacementId,
                fromAgent = false
            )
        }.throws(DisabledPlacementException())
    }
}

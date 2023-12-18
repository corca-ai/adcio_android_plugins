package ai.corca.adcio_placement

import ai.corca.adcio_placement.exception.BadRequestException
import ai.corca.adcio_placement.exception.DisabledPlacementException
import ai.corca.adcio_placement.exception.UnregisteredIdException
import ai.corca.adcio_placement.feature.AdcioPlacement
import ai.corca.adcio_placement.model.AdcioSuggestionRaw
import com.corcaai.adcio_core.feature.AdcioCore
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AdcioPlacementTest {

    private val sessionId = "a3e0efcc-bbed-4c73-b001-cd3d0c54e7a6"
    private val deviceId = "TP1A.220624.022"

    private val activatedPlacementId = "67592c00-a230-4c31-902e-82ae4fe71866"
    private val disabledPlacementId = "b79deee6-3a05-4be6-902c-23220f8fc2cb"
    private val randomUUID = "34afc940-3801-45f6-b558-2365b26c8196"
    private val notUUID = "test-uuid"

    @TestOnly
    fun testPlacementCallSuccess(
        adcioPlacement: AdcioPlacement,
        expectedResult: AdcioSuggestionRaw
    ) {
        every {
            adcioPlacement.adcioCreateSuggestion(
                sessionId = AdcioCore.sessionId,
                deviceId = AdcioCore.deviceId,
                placementId = activatedPlacementId,
            )
        } returns expectedResult
    }

    @TestOnly
    fun testIsThrowBadRequestException(
        adcioPlacement: AdcioPlacement
    ) {
        every {
            adcioPlacement.adcioCreateSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = notUUID,
            )
        } throws BadRequestException()
    }

    @TestOnly
    fun testIsThrowUnRegisterIdException(
        adcioPlacement: AdcioPlacement
    ) {
        every {
            adcioPlacement.adcioCreateSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = randomUUID,
            )
        } throws UnregisteredIdException()
    }

    @TestOnly
    fun testIsThrowDisabledPlacementException(
        adcioPlacement: AdcioPlacement
    ) {
        every {
            adcioPlacement.adcioCreateSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = disabledPlacementId,
            )
        } throws DisabledPlacementException()
    }

    @Test
    fun verifyPlacementCallSuccess() {
        val mockAdcioPlacement = mockk<AdcioPlacement>(relaxed = true)
        val mockResult = mockk<AdcioSuggestionRaw>()

        AdcioCore.initializeApp("f8f2e298-c168-4412-b82d-98fc5b4a114a")

        testPlacementCallSuccess(mockAdcioPlacement, mockResult)

        val result = mockAdcioPlacement.adcioCreateSuggestion(
            sessionId = AdcioCore.sessionId,
            deviceId = AdcioCore.deviceId,
            placementId = activatedPlacementId,
        )

        assertEquals(mockResult, result)
    }

    @Test
    fun verifyIsThrowBadRequestException() {
        val mockAdcioPlacement = mockk<AdcioPlacement>()

        testIsThrowBadRequestException(mockAdcioPlacement)

        assertThrows<BadRequestException> {
            mockAdcioPlacement.adcioCreateSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = notUUID,
            )
        }
    }

    @Test
    fun verifyIsThrowUnRegisterIdException() {
        val mockAdcioPlacement = mockk<AdcioPlacement>()

        testIsThrowUnRegisterIdException(mockAdcioPlacement)

        assertThrows<UnregisteredIdException> {
            mockAdcioPlacement.adcioCreateSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = randomUUID,
            )
        }
    }

    @Test
    fun verifyIsThrowDisabledPlacementException() {
        val mockAdcioPlacement = mockk<AdcioPlacement>()

        testIsThrowDisabledPlacementException(mockAdcioPlacement)

        assertThrows<DisabledPlacementException> {
            mockAdcioPlacement.adcioCreateSuggestion(
                sessionId = sessionId,
                deviceId = deviceId,
                placementId = disabledPlacementId,
            )
        }
    }
}

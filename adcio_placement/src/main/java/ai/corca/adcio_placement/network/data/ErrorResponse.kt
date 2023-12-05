package ai.corca.adcio_placement.network.data

import ai.corca.adcio_placement.exception.PlatformException
import ai.corca.adcio_placement.exception.UNKNOWN_EXCEPTION_MESSAGE
import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("statusCode") val statusCode: Int,
    @SerializedName("message") val message: Int,
)

fun ErrorResponse.toException(): PlatformException =
    PlatformException(
        code = statusCode.toString(),
        errorMessage = message.toString(),
    )

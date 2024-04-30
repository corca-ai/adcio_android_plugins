package ai.corca.adcio_placement.network.data.response.banner

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("statusCode") val statusCode: Int,
    @SerializedName("message") val message: Any,
)

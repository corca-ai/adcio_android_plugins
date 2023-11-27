package ai.corca.adcio_placement.network.data.request

import ai.corca.adcio_placement.enum.GenderType
import com.google.gson.annotations.SerializedName

data class SuggestionsRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("placementId") val placementId: String,
    @SerializedName("customerId") val customerId: String? = null,
    @SerializedName("placementPositionX") val placementPositionX: Int? = null,
    @SerializedName("placementPositionY") val placementPositionY: Int? = null,
    @SerializedName("fromAgent") val fromAgent: Boolean = false,
    @SerializedName("birthYear") val birthYear: Int? = null,
    @SerializedName("gender") val gender: GenderType? = null,
    @SerializedName("area") val area: String? = null,
)

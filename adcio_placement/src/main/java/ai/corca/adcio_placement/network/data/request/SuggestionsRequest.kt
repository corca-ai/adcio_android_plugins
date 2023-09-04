package ai.corca.adcio_placement.network.data.request

import com.google.gson.annotations.SerializedName

data class SuggestionsRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("placementId") val placementId: String,
    @SerializedName("customerId") val customerId: String? = null,
    @SerializedName("placementPosX") val placementPosX: Int? = null,
    @SerializedName("placementPosY") val placementPosY: Int? = null,
    @SerializedName("fromAgent") val fromAgent: Boolean = false,
    @SerializedName("age") val age: String? = null,
    @SerializedName("gender") val gender: String? = null ,
    @SerializedName("area") val area: String? = null,
)

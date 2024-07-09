package ai.corca.adcio_placement.network.data.request

import ai.corca.adcio_placement.enum.Gender
import com.google.gson.annotations.SerializedName

internal data class SuggestionsRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("placementId") val placementId: String,
    @SerializedName("customerId") val customerId: String? = null,
    @SerializedName("categoryId") val categoryId: String? = null,
    @SerializedName("clientId") val clientId: String? = null,
    @SerializedName("baselineProductIds") val baselineProductIds: List<String>? = null,
    @SerializedName("excludingProductIds") val excludingProductIds: List<String>? = null,
    @SerializedName("placementPositionX") val placementPositionX: Int? = null,
    @SerializedName("placementPositionY") val placementPositionY: Int? = null,
    @SerializedName("fromAgent") val fromAgent: Boolean = false,
    @SerializedName("userAgent") val userAgent: String,
    @SerializedName("filters") val filters: List<Map<String, Filters>>? = null,
    @SerializedName("targets") val targets: List<Targets>? = null,
    @SerializedName("sdkVersion") val sdkVersion: String
)

data class Targets(
    @SerializedName("keyName") val keyName: String,
    @SerializedName("values") val values: List<String>,
)

data class Filters(
    val equalTo: Any? = null,
    val not: Any? = null,
    val contains: String? = null,
)

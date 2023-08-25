package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

data class LogOptions(
    @SerializedName("requestId") val requestId: String,
    @SerializedName("adsetId") val adsetId: String,
)

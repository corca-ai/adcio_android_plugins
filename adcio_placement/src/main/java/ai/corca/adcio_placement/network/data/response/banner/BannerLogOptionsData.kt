package ai.corca.adcio_placement.network.data.response.banner

import com.google.gson.annotations.SerializedName

data class BannerLogOptionsData(
    @SerializedName("requestId") val requestId: String,
    @SerializedName("adsetId") val adsetId: String,
)

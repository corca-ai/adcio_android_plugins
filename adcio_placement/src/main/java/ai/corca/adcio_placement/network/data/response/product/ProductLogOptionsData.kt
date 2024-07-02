package ai.corca.adcio_placement.network.data.response.product

import com.google.gson.annotations.SerializedName

data class ProductLogOptionsData(
    @SerializedName("requestId") val requestId: String,
    @SerializedName("adsetId") val adsetId: String,
)

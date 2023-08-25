package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

data class AdcioSuggestion(
    @SerializedName("banner") val banner: Banner,
    @SerializedName("logOptions") val logOptions: LogOptions,
    @SerializedName("product") val product: Product,
)

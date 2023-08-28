package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

data class AdcioSuggestionData(
    @SerializedName("banner") val bannerData: BannerData?,
    @SerializedName("logOptions") val logOptionsData: LogOptionsData,
    @SerializedName("product") val productData: ProductData,
)

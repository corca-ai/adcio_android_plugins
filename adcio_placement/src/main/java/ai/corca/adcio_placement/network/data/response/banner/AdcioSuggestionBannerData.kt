package ai.corca.adcio_placement.network.data.response.banner

import com.google.gson.annotations.SerializedName

data class AdcioSuggestionBannerData(
    @SerializedName("banner") val bannerData: BannerData?,
    @SerializedName("logOptions") val logOptionsData: BannerLogOptionsData,
)

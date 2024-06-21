package ai.corca.adcio_placement.network.data.response.banner

import ai.corca.adcio_placement.network.data.response.RemoteMetaData
import com.google.gson.annotations.SerializedName

data class AdcioSuggestionBannerData(
    @SerializedName("banner") val bannerData: BannerData?,
    @SerializedName("logOptions") val logOptionsData: BannerLogOptionsData,
    @SerializedName("metadata") val metadata: RemoteMetaData,
)
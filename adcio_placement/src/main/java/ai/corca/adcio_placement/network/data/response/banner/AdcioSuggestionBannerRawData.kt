package ai.corca.adcio_placement.network.data.response.banner

import ai.corca.adcio_placement.network.data.response.RemoteMetaData
import com.google.gson.annotations.SerializedName

data class AdcioSuggestionBannerRawData(
    @SerializedName("suggestions") val suggestionDataList: List<AdcioSuggestionBannerData>,
    @SerializedName("metadata") val metadata: RemoteMetaData,
)

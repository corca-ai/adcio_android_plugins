package ai.corca.adcio_placement.network.data.response.banner

import com.google.gson.annotations.SerializedName

data class AdcioSuggestionBannerRawData(
    @SerializedName("suggestions") val suggestionDataList: List<AdcioSuggestionBannerData>,
)

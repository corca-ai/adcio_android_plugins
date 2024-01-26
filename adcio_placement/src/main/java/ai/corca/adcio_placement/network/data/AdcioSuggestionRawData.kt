package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

data class AdcioSuggestionRawData(
    @SerializedName("placement") val placementData: PlacementData,
    @SerializedName("suggestions") val suggestionDataList: List<AdcioSuggestionData>,
)

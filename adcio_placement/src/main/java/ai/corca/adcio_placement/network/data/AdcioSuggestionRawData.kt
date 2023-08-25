package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

data class AdcioSuggestionRawData(
    @SerializedName("placement") val placement: Placement,
    @SerializedName("suggestions") val suggestions: List<AdcioSuggestion>,
)

package ai.corca.adcio_placement.network.data.response.product

import com.google.gson.annotations.SerializedName

data class AdcioSuggestionProductRawData(
    @SerializedName("suggestions") val suggestionDataList: List<AdcioSuggestionProductData>,
)

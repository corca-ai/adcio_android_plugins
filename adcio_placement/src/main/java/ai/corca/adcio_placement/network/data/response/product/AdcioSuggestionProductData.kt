package ai.corca.adcio_placement.network.data.response.product

import ai.corca.adcio_placement.network.data.response.RemoteMetaData
import com.google.gson.annotations.SerializedName

data class AdcioSuggestionProductData(
    @SerializedName("logOptions") val logOptionsData: ProductLogOptionsData,
    @SerializedName("product") val productData: ProductData,
)
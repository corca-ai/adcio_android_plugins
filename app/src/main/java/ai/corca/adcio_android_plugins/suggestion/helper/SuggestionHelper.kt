package ai.corca.adcio_android_plugins.suggestion.helper

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.suggestion.currentLocation
import ai.corca.adcio_android_plugins.suggestion.currentUser
import ai.corca.adcio_android_plugins.suggestion.model.Production
import ai.corca.adcio_android_plugins.suggestion.utils.clearImpressionHistory
import ai.corca.adcio_android_plugins.suggestion.utils.getMockProducts
import ai.corca.adcio_placement.enum.Gender
import ai.corca.adcio_placement.feature.AdcioPlacement
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import ai.corca.adcio_placement.network.data.request.Filters
import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private val _productState = MutableStateFlow(emptyList<Production>())
val productions: StateFlow<List<Production>> = _productState

internal class GetSuggestionThread : Thread() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun run() {
        // adcioSuggest function allows you to receive products recommended by ADCIO’s AI.
        // You can get the placementId on the ADCIO Dashboard web page.
        // In addition, if you have user information such as customerId(like.userId),
        // age, gender, area, or information such as placement position related to the page,
        // the recommended prediction accuracy is higher.
        val adcioSuggestionRaw = AdcioPlacement.createAdvertisementProducts(
            clientId = "76dc12fa-5a73-4c90-bea5-d6578f9bc606",
            placementId = "5ae9907f-3cc2-4ed4-aaa4-4b20ac97f9f4",
            categoryId = "2179",
            excludingProductIds = listOf("1001"),
            customerId = currentUser.id,
            birthYear = currentUser.birthDate.year,
            gender = Gender.male,
            filters = mapOf(
                "price_excluding_tax" to Filters(not = 53636),
                "product_code" to Filters(contains = "KY"), 
                "province_id" to Filters(equalTo = 1)
            ),
        )

        // Clear impression history when suggestion api called
        clearImpressionHistory()

        handleResultData(adcioSuggestionRaw)
    }
}

@SuppressLint("NotifyDataSetChanged")
private fun handleResultData(adcioSuggestionRaw: AdcioSuggestionProductRaw) {
    val products: MutableList<Production> = getMockProducts().toMutableList()

    Log.d("isBaseline", adcioSuggestionRaw.metaData.isBaseline.toString())

    adcioSuggestionRaw.suggestions.forEach {
        products.add(
            Production(
                productId = it.product.idOnStore, // product.code = product id of client service
                name = it.product.name,
                image = it.product.image,
                price = it.product.price.toString(),
                logOption = AdcioLogOption(
                    requestId = it.logOptions.requestId,
                    adsetId = it.logOptions.adsetId
                ),
                isSuggested = true
            )
        )
    }

    _productState.value = products
}
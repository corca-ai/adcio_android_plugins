package ai.corca.adcio_android_plugins.suggestion.helper

import ai.corca.adcio_analytics.model.AdcioLogOption
import ai.corca.adcio_android_plugins.suggestion.currentLocation
import ai.corca.adcio_android_plugins.suggestion.currentUser
import ai.corca.adcio_android_plugins.suggestion.model.Production
import ai.corca.adcio_android_plugins.suggestion.utils.getMockProducts
import ai.corca.adcio_placement.feature.AdcioPlacement
import ai.corca.adcio_placement.model.product.AdcioSuggestionProductRaw
import android.annotation.SuppressLint
import android.os.Build
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
        val adcioSuggestionRaw = AdcioPlacement.adcioCreateSuggestionProducts(
            clientId = "f8f2e298-c168-4412-b82d-98fc5b4a114a",
            placementId = "67592c00-a230-4c31-902e-82ae4fe71866",
            customerId = currentUser.id,
            birthYear = currentUser.birthDate.year,
            gender = currentUser.gender.name,
            area = currentLocation
        )
        // You can receive an AdcioSuggestonRaw object as a result,

        handleResultData(adcioSuggestionRaw)
    }
}

@SuppressLint("NotifyDataSetChanged")
private fun handleResultData(adcioSuggestionRaw: AdcioSuggestionProductRaw) {
    val products: MutableList<Production> = getMockProducts().toMutableList()
    adcioSuggestionRaw.suggestions.forEach {
        products.add(
            Production(
                productId = it.product.idOnStore, // product.code = product id of client service
                name = it.product.name,
                image = it.product.image,
                price = it.product.price.toString(),
                logOption = AdcioLogOption(requestId = it.logOptions.requestId, adsetId = it.logOptions.adsetId),
                isSuggested = true
            )
        )
    }

    _productState.value = products
}
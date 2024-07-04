/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package ai.corca.analytics.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param storeId ADCIO Client ID of the store.
 * @param sessionId The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app.
 * @param deviceId The device identifier should be unique for each device. A customer can have multiple devices.
 * @param customerId The customer identifier which is generated and managed by the store. The store should configure `frontApi` parameter of ADCIO SDK so that the `customerId` can be sent to ADCIO API.
 * @param sdkVersion The version of the SDK
 * @param requestId Identifier for the suggestion request
 * @param productIdOnStore Product ID (on store).
 * @param adsetId Product ID / Banner ID
 * @param categoryIdOnStore Category ID (on store).
 * @param cartId Unique identifier of the cart to prevent duplicate cart tracking.
 * @param quantity Quantity of the product.
 * @param userAgent 
 */


data class TrackAddToCartRequestDto (

    /* ADCIO Client ID of the store. */
    @Json(name = "storeId")
    val storeId: kotlin.String,

    /* The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app. */
    @Json(name = "sessionId")
    val sessionId: kotlin.String,

    /* The device identifier should be unique for each device. A customer can have multiple devices. */
    @Json(name = "deviceId")
    val deviceId: kotlin.String,

    /* The customer identifier which is generated and managed by the store. The store should configure `frontApi` parameter of ADCIO SDK so that the `customerId` can be sent to ADCIO API. */
    @Json(name = "customerId")
    val customerId: kotlin.String? = null,

    /* The version of the SDK */
    @Json(name = "sdkVersion")
    val sdkVersion: kotlin.String? = null,

    /* Identifier for the suggestion request */
    @Json(name = "requestId")
    val requestId: kotlin.String? = null,

    /* Product ID (on store). */
    @Json(name = "productIdOnStore")
    val productIdOnStore: kotlin.String? = null,

    /* Product ID / Banner ID */
    @Json(name = "adsetId")
    val adsetId: kotlin.String? = null,

    /* Category ID (on store). */
    @Json(name = "categoryIdOnStore")
    val categoryIdOnStore: kotlin.String? = null,

    /* Unique identifier of the cart to prevent duplicate cart tracking. */
    @Json(name = "cartId")
    val cartId: kotlin.String? = null,

    /* Quantity of the product. */
    @Json(name = "quantity")
    val quantity: java.math.BigDecimal? = null,

    @Json(name = "userAgent")
    val userAgent: kotlin.String? = null

)


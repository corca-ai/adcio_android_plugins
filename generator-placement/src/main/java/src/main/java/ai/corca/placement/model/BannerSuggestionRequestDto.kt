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

package ai.corca.placement.model

import ai.corca.placement.model.SuggestionRequestTarget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param sessionId The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app.
 * @param deviceId The device identifier should be unique for each device. A customer can have multiple devices.
 * @param placementId Identifier for the placement which the suggestion will be placed.
 * @param customerId The customer identifier which is generated and managed by the store. The store should configure `frontApi` parameter of ADCIO SDK so that the `customerId` can be sent to ADCIO API.
 * @param sdkVersion The version of the SDK
 * @param placementPositionX The X coordinate of the placement in pixel.
 * @param placementPositionY The Y coordinate of the placement in pixel.
 * @param fromAgent Whether the request is from the ADCIO agent or not. Default value is `false`.
 * @param targets 
 * @param userAgent 
 */


data class BannerSuggestionRequestDto (

    /* The session starts when the customer visits the store. It persists until the customer closes the tab, browser or app. */
    @Json(name = "sessionId")
    val sessionId: kotlin.String,

    /* The device identifier should be unique for each device. A customer can have multiple devices. */
    @Json(name = "deviceId")
    val deviceId: kotlin.String,

    /* Identifier for the placement which the suggestion will be placed. */
    @Json(name = "placementId")
    val placementId: kotlin.String,

    /* The customer identifier which is generated and managed by the store. The store should configure `frontApi` parameter of ADCIO SDK so that the `customerId` can be sent to ADCIO API. */
    @Json(name = "customerId")
    val customerId: kotlin.String? = null,

    /* The version of the SDK */
    @Json(name = "sdkVersion")
    val sdkVersion: kotlin.String? = null,

    /* The X coordinate of the placement in pixel. */
    @Json(name = "placementPositionX")
    val placementPositionX: java.math.BigDecimal? = null,

    /* The Y coordinate of the placement in pixel. */
    @Json(name = "placementPositionY")
    val placementPositionY: java.math.BigDecimal? = null,

    /* Whether the request is from the ADCIO agent or not. Default value is `false`. */
    @Json(name = "fromAgent")
    val fromAgent: kotlin.Boolean? = null,

    @Json(name = "targets")
    val targets: kotlin.collections.List<SuggestionRequestTarget>? = null,

    @Json(name = "userAgent")
    val userAgent: kotlin.String? = null

)


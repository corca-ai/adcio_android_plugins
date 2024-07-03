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

package ai.corca.adcio_placement.model

import ai.corca.adcio_placement.model.Campaign
import ai.corca.adcio_placement.model.Creative

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param creatives 
 * @param id 
 * @param clientId 
 * @param campaigns 
 * @param type 
 * @param url 
 * @param name 
 * @param `data` 
 * @param categoryId 
 * @param productId 
 * @param activated 
 * @param deepLink 
 * @param appRoute 
 * @param startsAt 
 * @param endsAt 
 * @param createdAt 
 * @param deletedAt 
 */


data class BannerWithCreative (

    @Json(name = "creatives")
    val creatives: kotlin.collections.List<Creative>,

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "clientId")
    val clientId: kotlin.String,

    @Json(name = "campaigns")
    val campaigns: kotlin.collections.List<Campaign>,

    @Json(name = "type")
    val type: BannerWithCreative.Type,

    @Json(name = "url")
    val url: kotlin.String,

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "data")
    val `data`: kotlin.Any,

    @Json(name = "categoryId")
    val categoryId: kotlin.String?,

    @Json(name = "productId")
    val productId: kotlin.String?,

    @Json(name = "activated")
    val activated: kotlin.Boolean,

    @Json(name = "deepLink")
    val deepLink: kotlin.String?,

    @Json(name = "appRoute")
    val appRoute: kotlin.String?,

    @Json(name = "startsAt")
    val startsAt: java.time.OffsetDateTime,

    @Json(name = "endsAt")
    val endsAt: java.time.OffsetDateTime?,

    @Json(name = "createdAt")
    val createdAt: java.time.OffsetDateTime,

    @Json(name = "deletedAt")
    val deletedAt: java.time.OffsetDateTime?

) {

    /**
     * 
     *
     * Values: video,image
     */
    @JsonClass(generateAdapter = false)
    enum class Type(val value: kotlin.String) {
        @Json(name = "video") video("video"),
        @Json(name = "image") image("image");
    }
}


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

import ai.corca.adcio_placement.model.Client

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param idOnStore 
 * @param storeId 
 * @param sellerId 
 * @param name 
 * @param price 
 * @param discountPrice 
 * @param additionalInformation 
 * @param summary 
 * @param image 
 * @param includeInRecommendation 
 * @param url 
 * @param deepLink 
 * @param caption 
 * @param additionalImages 
 * @param decorationImages 
 * @param createdAt 
 * @param updatedAt 
 * @param deletedAt 
 * @param seller 
 */


data class ProductWithSeller (

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "idOnStore")
    val idOnStore: kotlin.String,

    @Json(name = "storeId")
    val storeId: kotlin.String,

    @Json(name = "sellerId")
    val sellerId: kotlin.String,

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "price")
    val price: java.math.BigDecimal,

    @Json(name = "discountPrice")
    val discountPrice: java.math.BigDecimal?,

    @Json(name = "additionalInformation")
    val additionalInformation: kotlin.collections.List<kotlin.Any>?,

    @Json(name = "summary")
    val summary: kotlin.String,

    @Json(name = "image")
    val image: kotlin.String,

    @Json(name = "includeInRecommendation")
    val includeInRecommendation: kotlin.Boolean,

    @Json(name = "url")
    val url: kotlin.String?,

    @Json(name = "deepLink")
    val deepLink: kotlin.String?,

    @Json(name = "caption")
    val caption: kotlin.String?,

    @Json(name = "additionalImages")
    val additionalImages: kotlin.collections.List<kotlin.String>?,

    @Json(name = "decorationImages")
    val decorationImages: kotlin.collections.List<kotlin.String>?,

    @Json(name = "createdAt")
    val createdAt: java.time.OffsetDateTime,

    @Json(name = "updatedAt")
    val updatedAt: java.time.OffsetDateTime,

    @Json(name = "deletedAt")
    val deletedAt: java.time.OffsetDateTime?,

    @Json(name = "seller")
    val seller: Client

)

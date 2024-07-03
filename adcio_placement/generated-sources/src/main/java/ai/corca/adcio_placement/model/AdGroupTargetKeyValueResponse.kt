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

import ai.corca.adcio_placement.model.AdGroupTargetKey

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param key 
 * @param id 
 * @param label 
 * @param `value` 
 * @param keyId 
 * @param createdAt 
 * @param deletedAt 
 */


data class AdGroupTargetKeyValueResponse (

    @Json(name = "key")
    val key: AdGroupTargetKey,

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "label")
    val label: kotlin.String,

    @Json(name = "value")
    val `value`: kotlin.String,

    @Json(name = "keyId")
    val keyId: kotlin.String,

    @Json(name = "createdAt")
    val createdAt: java.time.OffsetDateTime,

    @Json(name = "deletedAt")
    val deletedAt: java.time.OffsetDateTime

)


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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param keyName The name of the target.
 * @param propertyValues The value of the target.
 */


data class SuggestionRequestTarget (

    /* The name of the target. */
    @Json(name = "keyName")
    val keyName: kotlin.String,

    /* The value of the target. */
    @Json(name = "values")
    val propertyValues: kotlin.collections.List<kotlin.String>

)

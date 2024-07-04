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

import ai.corca.placement.model.LogOptionsDto
import ai.corca.placement.model.Product

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param product 
 * @param logOptions 
 */


data class ProductSuggestionDto (

    @Json(name = "product")
    val product: Product,

    @Json(name = "logOptions")
    val logOptions: LogOptionsDto

)


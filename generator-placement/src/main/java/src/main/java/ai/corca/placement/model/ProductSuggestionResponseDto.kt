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

import ai.corca.placement.model.ProductSuggestionDto
import ai.corca.placement.model.SuggestionResponsePlacementType

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param metadata 
 * @param suggestions 
 * @param placement 
 */


data class ProductSuggestionResponseDto (

    @Json(name = "metadata")
    val metadata: kotlin.Any,

    @Json(name = "suggestions")
    val suggestions: kotlin.collections.List<ProductSuggestionDto>,

    @Json(name = "placement")
    val placement: SuggestionResponsePlacementType

)


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

import ai.corca.placement.model.UpsertProductFailedRow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param failedRows 
 * @param insertedCount 
 */


data class UpsertManyProductResponseDto (

    @Json(name = "failedRows")
    val failedRows: kotlin.collections.List<UpsertProductFailedRow>,

    @Json(name = "insertedCount")
    val insertedCount: java.math.BigDecimal

)


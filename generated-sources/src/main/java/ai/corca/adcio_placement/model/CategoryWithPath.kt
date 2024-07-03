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
 * @param id 
 * @param idOnStore 
 * @param storeId 
 * @param name 
 * @param parentId 
 * @param deletedAt 
 * @param path 
 */


data class CategoryWithPath (

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "idOnStore")
    val idOnStore: kotlin.String,

    @Json(name = "storeId")
    val storeId: kotlin.String,

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "parentId")
    val parentId: kotlin.String?,

    @Json(name = "deletedAt")
    val deletedAt: java.time.OffsetDateTime?,

    @Json(name = "path")
    val path: kotlin.collections.List<kotlin.String>

)


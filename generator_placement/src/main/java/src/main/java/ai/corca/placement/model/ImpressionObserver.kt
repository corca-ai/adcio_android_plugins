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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param useIntersectionObserver 
 * @param className 
 * @param wrapper 
 */


data class ImpressionObserver (

    @Json(name = "useIntersectionObserver")
    val useIntersectionObserver: kotlin.Boolean? = null,

    @Json(name = "className")
    val className: kotlin.String? = null,

    @Json(name = "wrapper")
    val wrapper: kotlin.String? = null

)

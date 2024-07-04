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
 * @param path 
 * @param wrapper 
 * @param template 
 * @param swiper 
 * @param videoTemplate 
 * @param imageTemplate 
 */


data class WidgetInjector (

    @Json(name = "path")
    val path: kotlin.String,

    @Json(name = "wrapper")
    val wrapper: kotlin.String,

    @Json(name = "template")
    val template: kotlin.String? = null,

    @Json(name = "swiper")
    val swiper: kotlin.Any? = null,

    @Json(name = "videoTemplate")
    val videoTemplate: kotlin.String? = null,

    @Json(name = "imageTemplate")
    val imageTemplate: kotlin.String? = null

)

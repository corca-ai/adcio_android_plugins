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

import ai.corca.placement.model.Widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param widget 
 * @param widgetId 
 * @param propertyValues 
 * @param id 
 */


data class WidgetValue (

    @Json(name = "widget")
    val widget: Widget,

    @Json(name = "widgetId")
    val widgetId: kotlin.String,

    @Json(name = "values")
    val propertyValues: kotlin.Any,

    @Json(name = "id")
    val id: kotlin.String

)

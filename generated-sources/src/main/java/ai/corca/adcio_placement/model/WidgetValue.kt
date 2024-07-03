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

import ai.corca.adcio_placement.model.Widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param widget 
 * @param widgetId 
 * @param propertyValues 
 */


data class WidgetValue (

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "widget")
    val widget: Widget,

    @Json(name = "widgetId")
    val widgetId: kotlin.String,

    @Json(name = "values")
    val propertyValues: kotlin.Any

)


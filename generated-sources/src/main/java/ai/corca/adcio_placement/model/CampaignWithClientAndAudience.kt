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

import ai.corca.adcio_placement.model.Audience
import ai.corca.adcio_placement.model.Client

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param client 
 * @param audience 
 * @param id 
 * @param title 
 * @param placementId 
 * @param maxBudgetPerDay 
 * @param totalBudgetInPeriod 
 * @param budgetType 
 * @param usedBudget 
 * @param activated 
 * @param startsAt 
 * @param endsAt 
 * @param clientId 
 * @param clickLookbackWindowDays 
 * @param impressionLookbackWindowDays 
 * @param createdAt 
 * @param updatedAt 
 * @param deletedAt 
 */


data class CampaignWithClientAndAudience (

    @Json(name = "client")
    val client: Client,

    @Json(name = "audience")
    val audience: Audience,

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "title")
    val title: kotlin.String,

    @Json(name = "placementId")
    val placementId: kotlin.String,

    @Json(name = "maxBudgetPerDay")
    val maxBudgetPerDay: java.math.BigDecimal,

    @Json(name = "totalBudgetInPeriod")
    val totalBudgetInPeriod: java.math.BigDecimal?,

    @Json(name = "budgetType")
    val budgetType: CampaignWithClientAndAudience.BudgetType,

    @Json(name = "usedBudget")
    val usedBudget: java.math.BigDecimal,

    @Json(name = "activated")
    val activated: kotlin.Boolean,

    @Json(name = "startsAt")
    val startsAt: java.time.OffsetDateTime,

    @Json(name = "endsAt")
    val endsAt: java.time.OffsetDateTime?,

    @Json(name = "clientId")
    val clientId: kotlin.String,

    @Json(name = "clickLookbackWindowDays")
    val clickLookbackWindowDays: java.math.BigDecimal,

    @Json(name = "impressionLookbackWindowDays")
    val impressionLookbackWindowDays: java.math.BigDecimal?,

    @Json(name = "createdAt")
    val createdAt: java.time.OffsetDateTime,

    @Json(name = "updatedAt")
    val updatedAt: java.time.OffsetDateTime,

    @Json(name = "deletedAt")
    val deletedAt: java.time.OffsetDateTime?

) {

    /**
     * 
     *
     * Values: dAILYBUDGET,tOTALBUDGETINPERIOD,mAXBUDGETPERDAY
     */
    @JsonClass(generateAdapter = false)
    enum class BudgetType(val value: kotlin.String) {
        @Json(name = "DAILY_BUDGET") dAILYBUDGET("DAILY_BUDGET"),
        @Json(name = "TOTAL_BUDGET_IN_PERIOD") tOTALBUDGETINPERIOD("TOTAL_BUDGET_IN_PERIOD"),
        @Json(name = "MAX_BUDGET_PER_DAY") mAXBUDGETPERDAY("MAX_BUDGET_PER_DAY");
    }
}


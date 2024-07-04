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

import ai.corca.placement.model.AdGroupTargetKeyValueResponse
import ai.corca.placement.model.Campaign
import ai.corca.placement.model.Client

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param targets 
 * @param seller 
 * @param campaign 
 * @param id 
 * @param title 
 * @param type 
 * @param placementId 
 * @param maxBudgetPerDay 
 * @param totalBudgetInPeriod 
 * @param budgetType 
 * @param dailyUsedBudget 
 * @param totalUsedBudget 
 * @param activated 
 * @param startsAt 
 * @param endsAt 
 * @param sellerId 
 * @param campaignId 
 * @param createdAt 
 * @param updatedAt 
 * @param deletedAt 
 */


data class AdGroupWithSellerAndCampaign (

    @Json(name = "targets")
    val targets: kotlin.collections.List<AdGroupTargetKeyValueResponse>,

    @Json(name = "seller")
    val seller: Client,

    @Json(name = "campaign")
    val campaign: Campaign,

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "title")
    val title: kotlin.String,

    @Json(name = "type")
    val type: AdGroupWithSellerAndCampaign.Type,

    @Json(name = "placementId")
    val placementId: kotlin.String,

    @Json(name = "maxBudgetPerDay")
    val maxBudgetPerDay: java.math.BigDecimal,

    @Json(name = "totalBudgetInPeriod")
    val totalBudgetInPeriod: java.math.BigDecimal?,

    @Json(name = "budgetType")
    val budgetType: AdGroupWithSellerAndCampaign.BudgetType,

    @Json(name = "dailyUsedBudget")
    val dailyUsedBudget: java.math.BigDecimal,

    @Json(name = "totalUsedBudget")
    val totalUsedBudget: java.math.BigDecimal,

    @Json(name = "activated")
    val activated: kotlin.Boolean,

    @Json(name = "startsAt")
    val startsAt: java.time.OffsetDateTime,

    @Json(name = "endsAt")
    val endsAt: java.time.OffsetDateTime?,

    @Json(name = "sellerId")
    val sellerId: kotlin.String,

    @Json(name = "campaignId")
    val campaignId: kotlin.String,

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
     * Values: gRID
     */
    @JsonClass(generateAdapter = false)
    enum class Type(val value: kotlin.String) {
        @Json(name = "GRID") gRID("GRID");
    }
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


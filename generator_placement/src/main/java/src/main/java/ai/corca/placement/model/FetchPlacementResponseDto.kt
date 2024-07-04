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

import ai.corca.placement.model.AdGroupWithSellerAndCampaign
import ai.corca.placement.model.BannerWithCreative
import ai.corca.placement.model.FetchPageClientDto
import ai.corca.placement.model.Injector
import ai.corca.placement.model.ProductWithSeller

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param displayFormatHeight 
 * @param supportEnvironment 
 * @param developEnvironment 
 * @param title 
 * @param type 
 * @param pageName 
 * @param suggestionType 
 * @param productDetailDataColumns 
 * @param createdAt 
 * @param displayFormatWidth 
 * @param bannerPlacementType 
 * @param displayCount 
 * @param maxDisplayCount 
 * @param tableSize 
 * @param screenShot 
 * @param `property` 
 * @param id 
 * @param injector 
 * @param updatedAt 
 * @param clientId 
 * @param placementFormatRatio 
 * @param minDisplayCount 
 * @param deletedAt 
 * @param displayPositions 
 * @param page 
 * @param widgetValueId 
 * @param activated 
 * @param products 
 * @param banners 
 * @param adGroups 
 */


data class FetchPlacementResponseDto (

    @Json(name = "displayFormatHeight")
    val displayFormatHeight: java.math.BigDecimal?,

    @Json(name = "supportEnvironment")
    val supportEnvironment: FetchPlacementResponseDto.SupportEnvironment,

    @Json(name = "developEnvironment")
    val developEnvironment: FetchPlacementResponseDto.DevelopEnvironment,

    @Json(name = "title")
    val title: kotlin.String,

    @Json(name = "type")
    val type: FetchPlacementResponseDto.Type,

    @Json(name = "pageName")
    val pageName: kotlin.String,

    @Json(name = "suggestionType")
    val suggestionType: FetchPlacementResponseDto.SuggestionType,

    @Json(name = "productDetailDataColumns")
    val productDetailDataColumns: kotlin.collections.List<kotlin.String>?,

    @Json(name = "createdAt")
    val createdAt: java.time.OffsetDateTime,

    @Json(name = "displayFormatWidth")
    val displayFormatWidth: java.math.BigDecimal?,

    @Json(name = "bannerPlacementType")
    val bannerPlacementType: FetchPlacementResponseDto.BannerPlacementType?,

    @Json(name = "displayCount")
    val displayCount: java.math.BigDecimal?,

    @Json(name = "maxDisplayCount")
    val maxDisplayCount: java.math.BigDecimal,

    @Json(name = "tableSize")
    val tableSize: kotlin.collections.List<java.math.BigDecimal>?,

    @Json(name = "screenShot")
    val screenShot: kotlin.String,

    @Json(name = "property")
    val `property`: FetchPlacementResponseDto.`Property`?,

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "injector")
    val injector: Injector?,

    @Json(name = "updatedAt")
    val updatedAt: java.time.OffsetDateTime,

    @Json(name = "clientId")
    val clientId: kotlin.String,

    @Json(name = "placementFormatRatio")
    val placementFormatRatio: kotlin.String?,

    @Json(name = "minDisplayCount")
    val minDisplayCount: java.math.BigDecimal,

    @Json(name = "deletedAt")
    val deletedAt: java.time.OffsetDateTime?,

    @Json(name = "displayPositions")
    val displayPositions: kotlin.collections.List<java.math.BigDecimal>?,

    @Json(name = "page")
    val page: FetchPageClientDto,

    @Json(name = "widgetValueId")
    val widgetValueId: kotlin.String?,

    @Json(name = "activated")
    val activated: kotlin.Boolean,

    @Json(name = "products")
    val products: kotlin.collections.List<ProductWithSeller>? = null,

    @Json(name = "banners")
    val banners: kotlin.collections.List<BannerWithCreative>? = null,

    @Json(name = "adGroups")
    val adGroups: kotlin.collections.List<AdGroupWithSellerAndCampaign>? = null

) {

    /**
     * 
     *
     * Values: wEB,wEBMOBILE,aPP
     */
    @JsonClass(generateAdapter = false)
    enum class SupportEnvironment(val value: kotlin.String) {
        @Json(name = "WEB") wEB("WEB"),
        @Json(name = "WEB_MOBILE") wEBMOBILE("WEB_MOBILE"),
        @Json(name = "APP") aPP("APP");
    }
    /**
     * 
     *
     * Values: wIDGET,sELFDEVELOPED,cODEINJECTOR
     */
    @JsonClass(generateAdapter = false)
    enum class DevelopEnvironment(val value: kotlin.String) {
        @Json(name = "WIDGET") wIDGET("WIDGET"),
        @Json(name = "SELF_DEVELOPED") sELFDEVELOPED("SELF_DEVELOPED"),
        @Json(name = "CODE_INJECTOR") cODEINJECTOR("CODE_INJECTOR");
    }
    /**
     * 
     *
     * Values: gRID,bANNER
     */
    @JsonClass(generateAdapter = false)
    enum class Type(val value: kotlin.String) {
        @Json(name = "GRID") gRID("GRID"),
        @Json(name = "BANNER") bANNER("BANNER");
    }
    /**
     * 
     *
     * Values: rECOMMEND,aDVERTISE
     */
    @JsonClass(generateAdapter = false)
    enum class SuggestionType(val value: kotlin.String) {
        @Json(name = "RECOMMEND") rECOMMEND("RECOMMEND"),
        @Json(name = "ADVERTISE") aDVERTISE("ADVERTISE");
    }
    /**
     * 
     *
     * Values: sTATIC,sLIDE
     */
    @JsonClass(generateAdapter = false)
    enum class BannerPlacementType(val value: kotlin.String) {
        @Json(name = "STATIC") sTATIC("STATIC"),
        @Json(name = "SLIDE") sLIDE("SLIDE");
    }
    /**
     * 
     *
     * Values: nEW,hOT,pERSONAL,sAMEGOODS,dIFFGOODS
     */
    @JsonClass(generateAdapter = false)
    enum class `Property`(val value: kotlin.String) {
        @Json(name = "NEW") nEW("NEW"),
        @Json(name = "HOT") hOT("HOT"),
        @Json(name = "PERSONAL") pERSONAL("PERSONAL"),
        @Json(name = "SAME_GOODS") sAMEGOODS("SAME_GOODS"),
        @Json(name = "DIFF_GOODS") dIFFGOODS("DIFF_GOODS");
    }
}

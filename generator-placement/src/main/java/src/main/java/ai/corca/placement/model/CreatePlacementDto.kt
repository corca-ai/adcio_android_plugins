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

import ai.corca.placement.model.PlacementInjectorDto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param displayFormatHeight 
 * @param supportEnvironment 
 * @param developEnvironment 
 * @param placementFormatRatio 
 * @param title 
 * @param type 
 * @param pageName 
 * @param suggestionType 
 * @param displayFormatWidth 
 * @param minDisplayCount 
 * @param productDetailDataColumns 
 * @param bannerPlacementType 
 * @param maxDisplayCount 
 * @param displayCount 
 * @param tableSize 
 * @param displayPositions 
 * @param injector 
 */


data class CreatePlacementDto (

    @Json(name = "displayFormatHeight")
    val displayFormatHeight: java.math.BigDecimal?,

    @Json(name = "supportEnvironment")
    val supportEnvironment: CreatePlacementDto.SupportEnvironment,

    @Json(name = "developEnvironment")
    val developEnvironment: CreatePlacementDto.DevelopEnvironment,

    @Json(name = "placementFormatRatio")
    val placementFormatRatio: kotlin.String?,

    @Json(name = "title")
    val title: kotlin.String,

    @Json(name = "type")
    val type: CreatePlacementDto.Type,

    @Json(name = "pageName")
    val pageName: kotlin.String,

    @Json(name = "suggestionType")
    val suggestionType: CreatePlacementDto.SuggestionType,

    @Json(name = "displayFormatWidth")
    val displayFormatWidth: java.math.BigDecimal?,

    @Json(name = "minDisplayCount")
    val minDisplayCount: java.math.BigDecimal? = null,

    @Json(name = "productDetailDataColumns")
    val productDetailDataColumns: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "bannerPlacementType")
    val bannerPlacementType: CreatePlacementDto.BannerPlacementType? = null,

    @Json(name = "maxDisplayCount")
    val maxDisplayCount: java.math.BigDecimal? = null,

    @Json(name = "displayCount")
    val displayCount: java.math.BigDecimal? = null,

    @Json(name = "tableSize")
    val tableSize: kotlin.collections.List<java.math.BigDecimal>? = null,

    @Json(name = "displayPositions")
    val displayPositions: kotlin.collections.List<java.math.BigDecimal>? = null,

    @Json(name = "injector")
    val injector: PlacementInjectorDto? = null

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
}


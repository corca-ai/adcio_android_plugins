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

import ai.corca.adcio_placement.model.Banner
import ai.corca.adcio_placement.model.FetchPageClientDto
import ai.corca.adcio_placement.model.Injector
import ai.corca.adcio_placement.model.Product

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param placementFormatRatio 
 * @param page 
 * @param products 
 * @param banners 
 * @param id 
 * @param title 
 * @param type 
 * @param suggestionType 
 * @param bannerPlacementType 
 * @param supportEnvironment 
 * @param developEnvironment 
 * @param displayCount 
 * @param minDisplayCount 
 * @param maxDisplayCount 
 * @param activated 
 * @param pageName 
 * @param clientId 
 * @param injector 
 * @param screenShot 
 * @param displayFormatWidth 
 * @param displayFormatHeight 
 * @param `property` 
 * @param displayPositions 
 * @param tableSize 
 * @param widgetValueId 
 * @param productDetailDataColumns 
 * @param createdAt 
 * @param updatedAt 
 * @param deletedAt 
 */


data class FetchManyPlacementsResponseDto (

    @Json(name = "placementFormatRatio")
    val placementFormatRatio: kotlin.String?,

    @Json(name = "page")
    val page: FetchPageClientDto,

    @Json(name = "products")
    val products: kotlin.collections.List<Product>,

    @Json(name = "banners")
    val banners: kotlin.collections.List<Banner>,

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "title")
    val title: kotlin.String,

    @Json(name = "type")
    val type: FetchManyPlacementsResponseDto.Type,

    @Json(name = "suggestionType")
    val suggestionType: FetchManyPlacementsResponseDto.SuggestionType,

    @Json(name = "bannerPlacementType")
    val bannerPlacementType: FetchManyPlacementsResponseDto.BannerPlacementType?,

    @Json(name = "supportEnvironment")
    val supportEnvironment: FetchManyPlacementsResponseDto.SupportEnvironment,

    @Json(name = "developEnvironment")
    val developEnvironment: FetchManyPlacementsResponseDto.DevelopEnvironment,

    @Json(name = "displayCount")
    val displayCount: java.math.BigDecimal?,

    @Json(name = "minDisplayCount")
    val minDisplayCount: java.math.BigDecimal,

    @Json(name = "maxDisplayCount")
    val maxDisplayCount: java.math.BigDecimal,

    @Json(name = "activated")
    val activated: kotlin.Boolean,

    @Json(name = "pageName")
    val pageName: kotlin.String,

    @Json(name = "clientId")
    val clientId: kotlin.String,

    @Json(name = "injector")
    val injector: Injector?,

    @Json(name = "screenShot")
    val screenShot: kotlin.String,

    @Json(name = "displayFormatWidth")
    val displayFormatWidth: java.math.BigDecimal?,

    @Json(name = "displayFormatHeight")
    val displayFormatHeight: java.math.BigDecimal?,

    @Json(name = "property")
    val `property`: FetchManyPlacementsResponseDto.`Property`?,

    @Json(name = "displayPositions")
    val displayPositions: kotlin.collections.List<java.math.BigDecimal>?,

    @Json(name = "tableSize")
    val tableSize: kotlin.collections.List<java.math.BigDecimal>?,

    @Json(name = "widgetValueId")
    val widgetValueId: kotlin.String?,

    @Json(name = "productDetailDataColumns")
    val productDetailDataColumns: kotlin.collections.List<kotlin.String>?,

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


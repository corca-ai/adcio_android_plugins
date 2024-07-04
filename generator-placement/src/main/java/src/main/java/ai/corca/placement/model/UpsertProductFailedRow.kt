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
 * @param idOnStore 
 * @param name 
 * @param reasons 
 */


data class UpsertProductFailedRow (

    @Json(name = "idOnStore")
    val idOnStore: kotlin.String,

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "reasons")
    val reasons: kotlin.collections.List<UpsertProductFailedRow.Reasons>

) {

    /**
     * 
     *
     * Values: upsertProductFailedDeuplicatedRow,upsertProductFailedSellerIsNotExist,upsertProductFailedIdIsEmpty,upsertProductFailedNameIsEmpty,upsertProductFailedPriceIsEmpty,upsertProductFailedImageIsEmpty,upsertProductFailedImageIsInvalid,upsertProductFailedUrlIsInvalid,upsertProductFailedAdditionalImagesIsInvalid,upsertProductFailedDecorationImagesIsInvalid
     */
    @JsonClass(generateAdapter = false)
    enum class Reasons(val value: kotlin.String) {
        @Json(name = "upsertProductFailedDeuplicatedRow") upsertProductFailedDeuplicatedRow("upsertProductFailedDeuplicatedRow"),
        @Json(name = "upsertProductFailedSellerIsNotExist") upsertProductFailedSellerIsNotExist("upsertProductFailedSellerIsNotExist"),
        @Json(name = "upsertProductFailedIdIsEmpty") upsertProductFailedIdIsEmpty("upsertProductFailedIdIsEmpty"),
        @Json(name = "upsertProductFailedNameIsEmpty") upsertProductFailedNameIsEmpty("upsertProductFailedNameIsEmpty"),
        @Json(name = "upsertProductFailedPriceIsEmpty") upsertProductFailedPriceIsEmpty("upsertProductFailedPriceIsEmpty"),
        @Json(name = "upsertProductFailedImageIsEmpty") upsertProductFailedImageIsEmpty("upsertProductFailedImageIsEmpty"),
        @Json(name = "upsertProductFailedImageIsInvalid") upsertProductFailedImageIsInvalid("upsertProductFailedImageIsInvalid"),
        @Json(name = "upsertProductFailedUrlIsInvalid") upsertProductFailedUrlIsInvalid("upsertProductFailedUrlIsInvalid"),
        @Json(name = "upsertProductFailedAdditionalImagesIsInvalid") upsertProductFailedAdditionalImagesIsInvalid("upsertProductFailedAdditionalImagesIsInvalid"),
        @Json(name = "upsertProductFailedDecorationImagesIsInvalid") upsertProductFailedDecorationImagesIsInvalid("upsertProductFailedDecorationImagesIsInvalid");
    }
}


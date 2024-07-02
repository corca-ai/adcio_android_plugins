package ai.corca.adcio_placement.network.data.request

import ai.corca.adcio_placement.enum.Gender
import com.google.gson.annotations.SerializedName

internal data class SuggestionsRequest(
    @SerializedName("sessionId") val sessionId: String,
    @SerializedName("deviceId") val deviceId: String,
    @SerializedName("placementId") val placementId: String,
    @SerializedName("customerId") val customerId: String? = null,
    @SerializedName("categoryId") val categoryId: String? = null,
    @SerializedName("clientId") val clientId: String? = null,
    @SerializedName("excludingProductIds") val excludingProductIds: List<String>? = null,
    @SerializedName("placementPositionX") val placementPositionX: Int? = null,
    @SerializedName("placementPositionY") val placementPositionY: Int? = null,
    @SerializedName("fromAgent") val fromAgent: Boolean = false,
    @SerializedName("birthYear") val birthYear: Int? = null,
    @SerializedName("gender") val gender: Gender? = null,
    @SerializedName("filters") val filters: List<Map<String, Filters>>? = null,
)

// public struct Filter {
//    public let equalTo: Any?
//    public let not: Any?
//    public let contains: String?
//
//    public init(equalTo: Any? = nil, not: Any? = nil, contains: String? = nil) {
//        self.equalTo = equalTo
//        self.not = not
//        self.contains = contains
//    }
//}

data class Filters(
    val equalTo: Any? = null,
    val not: Any? = null,
    val contains: String? = null,
)

//data class ProvinceID(
//    val equalTo: Any? = null,
//    val not: Any? = null,
//    val `in`: List<Any>? = null,
//    val contains: String? = null
//)
//
//data class Filters(
//    val provinceID: ProvinceID
//) {
//    companion object {
//        fun toMap(filter: Filters?): Map<String, Any> {
//            val parameters = mutableMapOf<String, Any>()
//
//            filter?.provinceID?.let { provinceID ->
//                val filters = mutableListOf<Map<String, Any>>()
//
//                provinceID.equalTo?.let {
//                    filters.add(mapOf("province_id" to mapOf("equalTo" to it)))
//                }
//
//                provinceID.contains?.let {
//                    filters.add(mapOf("province_id" to mapOf("contains" to it)))
//                }
//
//                provinceID.`in`?.let {
//                    filters.add(mapOf("province_id" to mapOf("in" to it)))
//                }
//
//                provinceID.not?.let {
//                    filters.add(mapOf("province_id" to mapOf("not" to it)))
//                }
//
//                if (filters.isNotEmpty()) {
//                    parameters["filters"] = filters
//                }
//            }
//
//            return parameters
//        }
//    }
//}
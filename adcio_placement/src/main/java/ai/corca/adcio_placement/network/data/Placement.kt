package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

enum class Property { NEW, HOT, PERSONAL, SAME_GOODS, DIFF_GOODS }

enum class Type { GRID, BANNER }

enum class SuggestionType { RECOMMEND, ADVERTISE }

data class Placement(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: Type,
    @SerializedName("suggestionType") val suggestionType: SuggestionType,
    @SerializedName("displayCount") val displayCount: Int,
    @SerializedName("activated") val activated: Boolean,
    @SerializedName("clientId") val clientId: String,
    @SerializedName("pageUrl") val pageUrl: String,
    @SerializedName("screenShot") val screenShot: String,
    @SerializedName("displayFormatWidth") val displayFormatWidth: Int?,
    @SerializedName("displayFormatHeight") val displayFormatHeight: Int?,
    @SerializedName("property") val placementProperty: Property,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("deletedAt") val deletedAt: String,
)

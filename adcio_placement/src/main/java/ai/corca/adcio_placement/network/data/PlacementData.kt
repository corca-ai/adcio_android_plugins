package ai.corca.adcio_placement.network.data

import com.google.gson.annotations.SerializedName

enum class PropertyData { NEW, HOT, PERSONAL, SAME_GOODS, DIFF_GOODS }

enum class TypeData { GRID, BANNER }

enum class SuggestionTypeData { RECOMMEND, ADVERTISE }

data class PlacementData(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: TypeData,
    @SerializedName("suggestionType") val suggestionType: SuggestionTypeData,
    @SerializedName("displayCount") val displayCount: Int,
    @SerializedName("activated") val activated: Boolean,
    @SerializedName("clientId") val clientId: String,
    @SerializedName("pageUrl") val pageUrl: String?,
    @SerializedName("screenShot") val screenShot: String,
    @SerializedName("displayFormatWidth") val displayFormatWidth: Int?,
    @SerializedName("displayFormatHeight") val displayFormatHeight: Int?,
    @SerializedName("property") val placementProperty: PropertyData,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("deletedAt") val deletedAt: String?,
)

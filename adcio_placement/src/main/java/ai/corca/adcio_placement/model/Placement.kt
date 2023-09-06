package ai.corca.adcio_placement.model

enum class Property { NEW, HOT, PERSONAL, SAME_GOODS, DIFF_GOODS }

enum class Type { GRID, BANNER }

enum class SuggestionType { RECOMMEND, ADVERTISE }

data class Placement(
    val id: String,
    val title: String,
    val type: Type,
    val suggestionType: SuggestionType,
    val displayCount: Int,
    val activated: Boolean,
    val clientId: String,
    val pageUrl: String?,
    val screenShot: String,
    val displayFormatWidth: Int?,
    val displayFormatHeight: Int?,
    val placementProperty: Property,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
)

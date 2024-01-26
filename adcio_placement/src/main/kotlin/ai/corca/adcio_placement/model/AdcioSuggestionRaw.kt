package ai.corca.adcio_placement.model

data class AdcioSuggestionRaw(
    val placement: Placement,
    val suggestions: List<AdcioSuggestion>,
)

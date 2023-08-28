package ai.corca.adcio_analytics.feature

class AdcioAnalyticsHistory {
    private val adcioImpressionHistories: MutableSet<String> = mutableSetOf()

    /**
     * add impression log history in list
     *
     * @param adestId must be a adsetId
     * @return if list already has same product id will return false
     */
    fun addImpressionHistory(adestId: String): Boolean {
        val size = adcioImpressionHistories.size
        adcioImpressionHistories.add(adestId)
        return adcioImpressionHistories.size != size
    }

    /**
     * get log info history
     */
    fun getImpressionHistories(): List<String> = adcioImpressionHistories.toList()

    fun clearHistories() {
        adcioImpressionHistories.clear()
    }
}
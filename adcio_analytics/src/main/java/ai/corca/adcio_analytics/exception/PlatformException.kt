package ai.corca.adcio_analytics.exception

data class PlatformException(
    val code: Int,
    val errorMessage: String,
) : RuntimeException()

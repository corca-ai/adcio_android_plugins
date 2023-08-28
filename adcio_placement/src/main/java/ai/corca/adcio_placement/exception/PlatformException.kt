package ai.corca.adcio_placement.exception

internal const val UNKNOWN_EXCEPTION_MESSAGE = "Unknown error occurred"

data class PlatformException(
    val code: Int,
    val errorMessage: String,
) : RuntimeException()

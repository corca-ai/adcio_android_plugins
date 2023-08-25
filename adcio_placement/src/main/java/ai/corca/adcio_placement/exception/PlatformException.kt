package ai.corca.adcio_placement.exception

data class PlatformException(
    val code: Int,
    val errorMessage: String,
) : RuntimeException()

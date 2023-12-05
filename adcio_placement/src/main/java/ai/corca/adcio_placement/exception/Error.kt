package ai.corca.adcio_placement.exception

internal const val UNKNOWN_EXCEPTION_MESSAGE = "Unknown error occurred"

open class PlatformException(
    open val code: String,
    open val errorMessage: String
) : RuntimeException() {
    override fun toString(): String {
        return "PlatformException(code='$code', errorMessage='$errorMessage')"
    }
}

data class UnregisteredIdException(
    override val code: String = "PLACEMENT_NOT_FOUND",
    override val errorMessage: String = "placementID is not registered"
) : PlatformException(code, errorMessage)

data class DisabledPlacementException(
    override val code: String = "PLACEMENT_NOT_ACTIVATED",
    override val errorMessage: String = "The placement is not active"
) : PlatformException(code, errorMessage)

data class BadRequestException(
    override val code: String = "BAD_REQUEST",
    override val errorMessage: String
) : PlatformException(code, errorMessage)

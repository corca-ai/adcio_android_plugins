package ai.corca.adcio_android_plugins.suggestion.user

import java.time.LocalDate

enum class Gender { male, female }

data class User(
    val id: String,
    val name: String,
    val birthDate: LocalDate,
    val gender: Gender
)

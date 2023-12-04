package ai.corca.adcio_placement.utils

import ai.corca.adcio_placement.enum.Gender

internal fun convertGender(gender: String?): Gender? {

    return when (gender?.lowercase()) {
        "female", "f", "woman", "lady" -> Gender.female
        "male", "m", "man" -> Gender.male
        else -> null
    }
}
package ai.corca.convention

import org.gradle.api.JavaVersion

internal object ApplicationConstants {
    const val minSdk = 24
    const val targetSdk = 33
    const val compileSdk = 33
    const val versionCode = 32
    const val versionName = "1.4.0"
    val javaVersion = JavaVersion.VERSION_17
}
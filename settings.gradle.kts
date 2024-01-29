@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "adcio_android_plugins"

pluginManagement {
    pluginManagement {
        repositories {
            google()
            mavenLocal()
            mavenCentral()
            gradlePluginPortal()
        }
    }

    includeBuild("build-logic")
}

include(
    ":app",
    ":adcio_placement",
    ":adcio_agent",
    ":adcio_analytics",
    ":adcio_agent_compose",
    ":adcio_core"
)

include(":local-enums")
project(":local-enums").projectDir = file("build-logic/local-enums")

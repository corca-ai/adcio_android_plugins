@file:Suppress("UnstableApiUsage")

rootProject.name = "adcio_android_plugins"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    pluginManagement {
        repositories {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
    }

    includeBuild("build-logic")
    includeBuild("build-logic/local-enums")
}


include(
    ":app",
    ":adcio_placement",
    ":adcio_agent",
    ":adcio_analytics",
    ":adcio_agent_compose",
    ":adcio_core",
)

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "adcio_android_plugins"
include(":app")
include(":adcio_placement")
include(":adcio_agent")
include(":adcio_analytics")
include(":adcio_agent_compose")
include(":core")

buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2")
    }

    dependencies {
        classpath("io.github.gradle-nexus:publish-plugin:1.1.0")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0" apply true
}

apply(from = "${rootDir}/scripts/publish-root.gradle")

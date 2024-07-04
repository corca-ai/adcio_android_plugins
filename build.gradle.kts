buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2")
    }

    dependencies {
        classpath("io.github.gradle-nexus:publish-plugin:1.1.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.7.21" apply false
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.openapi.generator") version "6.6.0" apply false
    id("de.undercouch.download") version "5.6.0" apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0" apply true
}

subprojects {
    apply(plugin = "org.openapi.generator")

    repositories {
        google()
        mavenCentral()
    }

    afterEvaluate {
        dependencies {
            add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.21")
            add("testImplementation", "junit:junit:4.13.2")
            add("implementation", "com.squareup.retrofit2:retrofit:2.11.0")
            add("implementation", "com.squareup.retrofit2:converter-gson:2.9.0")
            add("implementation", "com.squareup.retrofit2:converter-moshi:2.9.0")
            add("implementation", "com.squareup.retrofit2:converter-scalars:2.9.0")
            add("implementation", "com.squareup.moshi:moshi:1.15.1")
            add("implementation", "com.squareup.moshi:moshi-kotlin:1.15.1")
            add("implementation", "com.squareup.okhttp3:logging-interceptor:4.9.2")
            add("implementation", "io.github.corca-ai:core:1.0.3")
        }
    }
}

apply(from = "${rootDir}/scripts/publish-root.gradle")

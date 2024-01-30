@file:Suppress("DSL_SCOPE_VIOLATION")

import DependencyHandler.Extensions.implementations
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    id(libs.plugins.local.convention.enum.get().pluginId) version "0.1.0"
    alias(libs.plugins.util.dependency.handler.extensions)
}

group = "ai.corca.local"

dependencies {
    implementations(
        libs.kotlin.core,
        libs.build.gradle.agp,
        libs.build.dependency.handler.extensions,
        libs.build.local.plugin.enum
    )
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationPlugin") {
            id = ConventionEnum.AndroidApplication
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibraryPlugin") {
            id = ConventionEnum.AndroidLibrary
            implementationClass = "AndroidLibraryPlugin"
        }
        register("jvmJunit4Plugin") {
            id = ConventionEnum.JvmJUnit4
            implementationClass = "JvmJUnit4Plugin"
        }
        register("androidLibraryComposePlugin") {
            id = ConventionEnum.AndroidLibraryCompose
            implementationClass = "AndroidLibraryComposePlugin"
        }
        register("androidLibraryViewBindingPlugin") {
            id = ConventionEnum.AndroidLibraryViewBinding
            implementationClass = "AndroidLibraryViewBindingPlugin"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}
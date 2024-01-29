@file:Suppress("DSL_SCOPE_VIOLATION")

import DependencyHandler.Extensions.implementations

plugins {
    `kotlin-dsl`
    alias(libs.plugins.util.dependency.handler.extensions)
    alias(libs.plugins.local.convention.enum)
}

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

@file:Suppress("DSL_SCOPE_VIOLATION")

import DependencyHandler.Extensions.implementations

plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.dokka)
    alias(libs.plugins.util.dependency.handler.extensions)
    alias(libs.plugins.local.convention.enum)
}

group = "ai.corca.local"

dependencies {
    implementations(
        libs.kotlin.core,
        libs.kotlin.dokka.base,
        libs.kotlin.dokka.plugin,
        libs.build.gradle.agp,
        libs.build.dependency.handler.extensions,
        libs.build.local.plugin.enum
    )
    compileOnly(libs.ksp.gradlePlugin)
}

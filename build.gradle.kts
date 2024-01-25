// Top-level build file where you can add configuration options common to all sub-projects/modules.

@file:Suppress("DSL_SCOPE_VIOLATION", "PropertyName")

plugins {
    alias(libs.plugins.code.ktlint)
    alias(libs.plugins.code.detekt)
    alias(libs.plugins.kotlin.dokka)
    alias(libs.plugins.local.convention.enum)
    alias(libs.plugins.local.plugin.enum)
    alias(libs.plugins.util.dependency.handler.extensions)
    alias(libs.plugins.publish.plugin)
}

buildscript {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.kotlin.core)
        classpath(libs.kotlin.dokka.base)
        classpath(libs.build.gradle.agp)
    }
}

allprojects {
    apply {
        plugin(rootProject.libs.plugins.code.ktlint.get().pluginId)
        plugin(rootProject.libs.plugins.local.convention.enum.get().pluginId)
        plugin(rootProject.libs.plugins.util.dependency.handler.extensions.get().pluginId)
    }

    repositories {
        google()
        mavenCentral()
    }
}

apply(from = "${rootDir}/scripts/publish-root.gradle")

subprojects {
    @Suppress("UnstableApiUsage")
    if (
        gradle.startParameter.isConfigureOnDemand &&
        buildscript.sourceFile?.extension?.lowercase() == "kts" &&
        parent != rootProject
    ) {
        generateSequence(parent) { project ->
            project.parent.takeIf { parent ->
                parent != rootProject
            }
        }.forEach { project ->
            evaluationDependsOn(project.path)
        }
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set(rootProject.libs.versions.plugin.code.ktlint.core.get())
        android.set(true)
        outputToConsole.set(true)

        @Suppress("DEPRECATION")
        additionalEditorconfigFile.set(file("$rootDir/.editorconfig"))
    }
}

tasks.register(
    name = "cleanAll",
    type = Delete::class
) {
    allprojects.map(Project::getBuildDir).forEach(::delete)
}

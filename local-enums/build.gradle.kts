import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "ai.corca.local"
version = "master"

gradlePlugin {
    plugins {
        create("conventionEnumPlugin") {
            id = "ai.corca.local.convention.enum"
            version = "master"
            implementationClass = "ConventionEnum"
        }
        create("pluginEnumPlugin") {
            id = "ai.corca.local.plugin.enum"
            version = "master"
            implementationClass = "PluginEnum"
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
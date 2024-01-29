import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "ai.corca.local"
version = "0.1.0"

gradlePlugin {
    plugins {
        create("conventionEnumPlugin") {
            id = "ai.corca.local.convention.enum"
            version = "0.1.0"
            implementationClass = "ConventionEnum"
        }
        create("pluginEnumPlugin") {
            id = "ai.corca.local.plugin.enum"
            version = "0.1.0"
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
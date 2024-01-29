import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            group = "ai.corca.local"
            artifactId = "library"
            version = "master"
        }
    }
}

gradlePlugin {
    plugins {
        create("conventionEnumPlugin") {
            id = "ai.corca.local.convention.enum"
            implementationClass = "ConventionEnum"
        }
        create("pluginEnumPlugin") {
            id = "ai.corca.local.plugin.enum"
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
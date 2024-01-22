@file:Suppress("UnstableApiUsage", "UnusedReceiverParameter")

import ai.corca.convention.ApplicationConstants
import org.gradle.api.Project
import com.android.build.api.dsl.CommonExtension

internal fun Project.configureApplication(extension: CommonExtension<*, *, *, *>) {
    extension.apply {
        compileSdk = ApplicationConstants.compileSdk

        defaultConfig {
            minSdk = ApplicationConstants.minSdk
        }

        sourceSets {
            getByName("main").java.srcDirs("src/main/kotlin/")
        }

        compileOptions {
            sourceCompatibility = ApplicationConstants.javaVersion
            targetCompatibility = ApplicationConstants.javaVersion
        }

        lint {
            checkTestSources = true
        }
    }
}
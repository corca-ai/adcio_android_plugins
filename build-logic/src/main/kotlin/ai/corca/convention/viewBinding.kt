package ai.corca.convention

import DependencyHandler.Extensions.implementations
import com.android.build.api.dsl.CommonExtension
import kotlinOptions
import libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureViewBinding(extension: CommonExtension<*, *, *, *>) {
    extension.apply {
        buildFeatures {
            viewBinding = true
        }
        dependencies {
            implementations(
                libs.findBundle("xml-core").get()
            )
        }
    }
}
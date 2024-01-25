@file:Suppress("UnstableApiUsage")

import ai.corca.convention.configureViewBinding
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryViewBindingPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<LibraryExtension>()
            configureViewBinding(extension)
        }
    }
}

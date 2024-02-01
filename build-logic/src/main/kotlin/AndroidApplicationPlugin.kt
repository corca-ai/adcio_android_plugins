@file:Suppress("UnstableApiUsage")

import ai.corca.convention.ApplicationConstants
import ai.corca.convention.configureViewBinding
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins(
                PluginEnum.AndroidApplication,
                PluginEnum.KotlinAndroid,
            )

            extensions.configure<BaseAppModuleExtension> {
                configureApplication(this)
                configureCompose(this)
                configureViewBinding(this)

                defaultConfig {
                    targetSdk = ApplicationConstants.targetSdk
                    versionName = ApplicationConstants.versionName
                    versionCode = ApplicationConstants.versionCode
                }

                 buildTypes {
                     release {
                         isShrinkResources = true
                         isMinifyEnabled = true
                     }
                 }
            }
        }
    }
}
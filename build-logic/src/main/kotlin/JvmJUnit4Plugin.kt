import DependencyHandler.Extensions.testImplementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class JvmJUnit4Plugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
//                setupJunit(
//                    core = libs.findLibrary("test-junit-core").get(),
//                    engine = libs.findLibrary("test-junit-engine").get(),
//                )
//                testImplementations(libs.findLibrary("test-strikt").get())
            }
        }
    }
}
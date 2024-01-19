import org.gradle.api.Plugin
import org.gradle.api.Project

class ConventionEnum: Plugin<Project> {
    override fun apply(target: Project) = Unit

    companion object {
        private const val prefix = "corcaai"

        const val AppVersionNameProvider = "$prefix.app.version.name.provider"

        const val AndroidApplication = "$prefix.android.application"
        const val AndroidApplicationCompose = "$prefix.android.application.compose"

        const val AndroidLibrary = "$prefix.android.library"
        const val AndroidLibraryCompose = "$prefix.android.library.compose"
        const val AndroidLibraryComposeUiTest = "$prefix.android.library.compose.uitest"

        const val JvmLibrary = "$prefix.jvm.library"
        const val JvmJUnit4 = "$prefix.jvm.junit4"
        const val JvmDokka = "$prefix.jvm.dokka"
    }
}
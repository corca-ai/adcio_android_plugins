import DependencyHandler.Extensions.androidTestImplementations
import DependencyHandler.Extensions.implementations

plugins {
    id(ConventionEnum.AndroidLibrary)
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_placement")
    set("PUBLISH_VERSION", "0.1.3")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_placement is adcio suggestion library")
}

android {
    namespace = "ai.corca.adcio_placement"

    packagingOptions.setExcludes(
        setOf(
            "META-INF/LICENSE.md",
            "META-INF/DEPENDENCIES",
            "META-INF/LICENSE",
            "LICENSE.txt",
            "META-INF/NOTICE",
            "META-INF/MANIFEST.MF",
            "META-INF/LICENSE-notice.md"
        )
    )
}

apply(from = "$rootDir/scripts/publish-module.gradle")

dependencies {

    androidTestImplementations(
        libs.junit,
        libs.test.mock,
        libs.test.espresso
    )

    implementations(
        libs.retrofit,
        libs.retrofit.json,
        libs.okhttp,

        libs.adcio.core,
        libs.adcio.analytics
    )
}

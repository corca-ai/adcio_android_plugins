plugins {
    id(ConventionEnum.AndroidLibrary)
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_core")
    set("PUBLISH_VERSION", "0.1.3")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_core is adcio service library")
}

android {
    namespace = "ai.corca.adcio_core"
}

apply(from = "$rootDir/scripts/publish-module.gradle")

dependencies {

    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:core-ktx:1.5.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")

    implementation("androidx.test.ext:junit-ktx:1.1.5")
}

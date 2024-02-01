plugins {
    id(ConventionEnum.AndroidLibrary)
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_analytics")
    set("PUBLISH_VERSION", "0.1.3")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_analytics is log event collection")
}

android {
    namespace = "ai.corca.adcio_analytics"
}

apply(from = "$rootDir/scripts/publish-module.gradle")

dependencies {

    implementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.espresso)

    implementation(libs.retrofit)
    implementation(libs.retrofit.json)
    implementation(libs.okhttp)

    implementation(libs.adcio.core)
}

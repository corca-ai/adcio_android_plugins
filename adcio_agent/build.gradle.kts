plugins {
    id(ConventionEnum.AndroidLibrary)
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_agent")
    set("PUBLISH_VERSION", "0.1.2")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "agent is adcio chatbot based on LLM(GPT)")
}

android {
    namespace = "ai.corca.adcio_agent"
}

apply(from = "$rootDir/scripts/publish-module.gradle")

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)

    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.espresso)

    implementation(libs.adcio.core)
}

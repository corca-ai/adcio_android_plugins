plugins {
    id(ConventionEnum.AndroidLibrary)
    id(ConventionEnum.AndroidLibraryCompose)
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_agent_compose")
    set("PUBLISH_VERSION", "0.1.3")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "agent_compose is adcio chatbot based on LLM(GPT) for compose ui")
}

android {
    namespace = "ai.corca.adcio_agent_compose"
}

apply(from = "$rootDir/scripts/publish-module.gradle")

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)

    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.espresso)

    implementation(libs.compose.accompanist)

    implementation(libs.adcio.core)
}

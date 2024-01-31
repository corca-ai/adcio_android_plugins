plugins {
    id(ConventionEnum.AndroidApplication)
}

android {
    namespace = "ai.corca.adcio_android_plugins"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)

    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.espresso)

    implementation(libs.glide)


    implementation(files("../build-logic/local-enums/build/libs/local-enums.jar"))
    implementation(project(path = ":adcio_core"))
    implementation(project(path = ":adcio_analytics"))
    implementation(project(path = ":adcio_placement"))
    implementation(project(path = ":adcio_agent"))
    implementation(project(path = ":adcio_agent_compose"))
}

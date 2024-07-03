import org.openapitools.generator.gradle.plugin.tasks.GenerateTask
import de.undercouch.gradle.tasks.download.Download

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
    id("org.openapi.generator") version "6.6.0"
    id("de.undercouch.download") version "5.6.0"
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_analytics")
    set("PUBLISH_VERSION", "1.3.1")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_analytics is log event collection")
}

val basePackage = "ai.corca.adcio_analytics"
val targetDir = "$buildDir/generated"
val targetFileName = "analytics-swagger.json"

tasks.register<Download>("downloadSwagger") {
    src("https://receiver.adcio.ai/api-json")
    dest(file("$buildDir/$targetFileName"))
    onlyIfModified(true)
    useETag(true)
}

tasks.register<GenerateTask>("generateClient") {
    dependsOn(tasks.named("downloadSwagger"))
    generatorName.set("kotlin")
    inputSpec.set("$buildDir/$targetFileName")
    outputDir.set(targetDir)
    apiPackage.set("$basePackage.api")
    modelPackage.set("$basePackage.model")
    invokerPackage.set("$basePackage.invoker")
    configOptions.set(
        mapOf(
            "library" to "jvm-retrofit2",
            "dateLibrary" to "java11",
            "omitGradleWrapper" to "true",
            "sourceFolder" to "src/main/java",
            "useCoroutines" to "false"
        )
    )
}

android {
    namespace = "ai.corca.adcio_analytics"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets["main"].java.srcDirs("$targetDir/src/main/java")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi:1.15.1")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")

    implementation("io.github.corca-ai:core:1.0.3")
}

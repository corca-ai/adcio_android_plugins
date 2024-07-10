import org.openapitools.generator.gradle.plugin.tasks.GenerateTask
import de.undercouch.gradle.tasks.download.Download

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
    id("org.openapi.generator")
    id("de.undercouch.download")
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_analytics")
    set("PUBLISH_VERSION", "1.4.3")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_analytics is log event collection")
}

val basePackage = "ai.corca.generator_analytics"
val targetDir = "${project.rootDir}/adcio_analytics/generator"
val targetFileName = "analytics-swagger.json"

// Swagger 파일 다운로드 태스크
tasks.register<Download>("downloadSwagger") {
    src("https://receiver.adcio.ai/api-json")
    dest(file("$targetDir/$targetFileName"))
    onlyIfModified(true)
    useETag(true)
}

// OpenAPI Generator 태스크
tasks.register<GenerateTask>("generateClient") {
    dependsOn(tasks.named("downloadSwagger"))
    generatorName.set("kotlin")
    inputSpec.set("$targetDir/$targetFileName")
    outputDir.set("$targetDir/src/main/java")
    apiPackage.set("$basePackage.api")
    modelPackage.set("$basePackage.model")
    invokerPackage.set("$basePackage.invoker")
    configOptions.set(
        mapOf(
            "library" to "jvm-retrofit2",
            "dateLibrary" to "java11",
            "omitGradleWrapper" to "true",
            "sourceFolder" to "src/main/java",
            "useCoroutines" to "false",
            "groupId" to basePackage,
            "packageName" to basePackage
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // 생성된 소스를 main 소스셋에 추가
    sourceSets["main"].java.srcDir("$targetDir/src/main/java")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("io.github.corca-ai:core:1.0.3")
}

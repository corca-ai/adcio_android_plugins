import org.openapitools.generator.gradle.plugin.tasks.GenerateTask
import de.undercouch.gradle.tasks.download.Download
import org.jose4j.json.internal.json_simple.JSONObject
import org.jose4j.json.internal.json_simple.parser.JSONParser
import java.io.File

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
    id("org.openapi.generator")
    id("de.undercouch.download")
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", "io.github.corca-ai")
    set("PUBLISH_ARTIFACT_ID", "adcio_placement")
    set("PUBLISH_VERSION", "1.3.2")
    set("PUBLISH_SCM_URL", "https://github.com/corca-ai/adcio_android_plugins")
    set("PUBLISH_DESCRIPTION", "adcio_placement is adcio suggestion library")
}

val basePackage = "ai.corca.placement"
val targetDir = "${project.rootDir}/generator-placement"
val targetFileName = "placement-swagger.json"
val filteredFileName = "filtered-placement-swagger.json"
val operationIds = listOf(
    "RecommendationsController_recommendBanners",
    "RecommendationsController_recommendProducts",
    "AdvertisementsController_advertiseProducts",
    "AdvertisementsController_advertiseBanners"
)

tasks.register<Download>("downloadSwagger") {
    src("https://api.adcio.ai/api-json")
    dest(file("$targetDir/$targetFileName"))
    onlyIfModified(true)
    useETag(true)
}

tasks.register("filterSwagger") {
    dependsOn("downloadSwagger")
    doLast {
        val inputFile = File("$targetDir/$targetFileName")
        val outputFile = File("$targetDir/$filteredFileName")
        val parser = JSONParser()
        val json = parser.parse(inputFile.reader()) as JSONObject

        val paths = json["paths"] as JSONObject

        val filteredPaths = JSONObject()

        paths.forEach { path, pathItem ->
            val pathItemObject = pathItem as JSONObject
            val filteredPathItem = JSONObject()

            pathItemObject.forEach { method, operation ->
                val operationObject = operation as JSONObject
                val operationId = operationObject["operationId"] as String
                if (operationId in operationIds) {
                    filteredPathItem[method] = operationObject
                }
            }

            if (filteredPathItem.isNotEmpty()) {
                filteredPaths[path as String] = filteredPathItem
            }
        }

        json["paths"] = filteredPaths
        outputFile.writeText(JSONObject.toJSONString(json))
    }
}

tasks.register<GenerateTask>("generateClient") {
    dependsOn("filterSwagger")
    generatorName.set("kotlin")
    inputSpec.set("$targetDir/$filteredFileName")
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
        )
    )
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    dependsOn(tasks.named("generateClient"))
}

android {
    namespace = "ai.corca.adcio_placement"
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
    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/LICENSE.md",
                "META-INF/DEPENDENCIES",
                "META-INF/LICENSE",
                "LICENSE.txt",
                "META-INF/NOTICE",
                "META-INF/MANIFEST.MF",
                "META-INF/LICENSE-notice.md"
            )
        }
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    sourceSets["main"].java.srcDir("$targetDir/src/main/java")
}

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("io.github.corca-ai:core:1.0.3")

    implementation("org.slf4j:slf4j-simple:2.0.13")

    implementation(project(":generator-placement"))
}

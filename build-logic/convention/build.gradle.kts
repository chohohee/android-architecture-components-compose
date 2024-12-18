plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "chh.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidCompose") {
            id = "chh.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "chh.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "chh.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "chh.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("hiltAndroid") {
            id = "chh.hilt.android"
            implementationClass = "HiltAndroidConventionPlugin"
        }
        register("hiltKotlin") {
            id = "chh.hilt.kotlin"
            implementationClass = "HiltKotlinConventionPlugin"
        }
    }
}

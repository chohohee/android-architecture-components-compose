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
        register("androidLibrary") {
            id = "chh.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "chh.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
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

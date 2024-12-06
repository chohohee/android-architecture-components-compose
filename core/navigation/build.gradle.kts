plugins {
    id("chh.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.chh.compose.core.navigation"
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
}

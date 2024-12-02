plugins {
    id("chh.android.library")
    id("chh.android.compose")
    id("chh.hilt.android")
}

android {
    namespace = "com.chh.compose.feature.main"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(libs.androidx.activity.compose)
}

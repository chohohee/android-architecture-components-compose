plugins {
    id("chh.android.library")
    id("chh.android.compose")
}

android {
    namespace = "com.chh.compose.feature.main"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(libs.androidx.activity.compose)
}

plugins {
    id("chh.android.library")
    id("chh.android.compose")
}

android {
    namespace = "com.chh.compose.core.ui"
}

dependencies {
    implementation(projects.core.designsystem)
}
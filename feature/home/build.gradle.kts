plugins {
    id("chh.android.library")
    id("chh.android.compose")
    id("chh.hilt.android")
}

android {
    namespace = "com.chh.compose.feature.home"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)
    implementation(projects.core.domain)
    implementation(projects.core.model)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.hilt.navigation.compose)
}

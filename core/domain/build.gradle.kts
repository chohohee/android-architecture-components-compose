plugins {
    id("chh.android.library")
}

android {
    namespace = "com.chh.compose.core.domain"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)

    implementation(libs.inject)
    implementation(libs.androidx.paging.common)
}
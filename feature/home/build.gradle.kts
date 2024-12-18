plugins {
    id("chh.android.feature")
}

android {
    namespace = "com.chh.compose.feature.home"
}

dependencies {
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
}

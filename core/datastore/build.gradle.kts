plugins {
    id("chh.android.library")
    id("chh.hilt.android")
}

android {
    namespace = "com.chh.compose.core.datastore"
}

dependencies {
    implementation(libs.androidx.datastore)
}
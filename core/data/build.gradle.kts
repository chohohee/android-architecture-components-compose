plugins {
    id("chh.android.library")
    id("chh.hilt.kotlin")
}

android {
    namespace = "com.chh.compose.core.data"
}

dependencies {
    implementation(projects.core.datastore)
    implementation(projects.core.model)
    implementation(projects.core.network)

    implementation(libs.androidx.paging.common)
}

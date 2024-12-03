plugins {
    id("chh.kotlin.library")
    id("chh.hilt.kotlin")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
}

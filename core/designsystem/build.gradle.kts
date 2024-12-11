plugins {
    id("chh.android.library")
    id("chh.android.compose")
}

android {
    namespace = "com.chh.compose.core.designsystem"
}

dependencies {
    implementation(libs.landscapist.bom)
    implementation(libs.landscapist.placeholder)
    api(libs.landscapist.coil)
    api(libs.landscapist.palette)
}
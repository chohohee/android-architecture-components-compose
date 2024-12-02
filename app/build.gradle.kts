plugins {
    id("chh.android.application")
}

android {
    namespace = "com.chh.compose"

    defaultConfig {
        applicationId = "com.chh.compose"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.feature.main)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
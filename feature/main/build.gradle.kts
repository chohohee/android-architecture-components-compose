plugins {
    id("chh.android.library")
    id("chh.android.compose")
    id("chh.hilt.android")
}

android {
    namespace = "com.chh.compose.feature.main"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(projects.core.navigation)
    implementation(projects.feature.home)
    implementation(projects.feature.pokemonDetail)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
}

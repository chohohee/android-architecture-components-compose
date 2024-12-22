plugins {
    id("chh.android.feature")
}

android {
    namespace = "com.chh.compose.feature.main"
}

dependencies {
    implementation(projects.feature.attribute)
    implementation(projects.feature.pokemon)
    implementation(projects.feature.pokemonDetail)
}

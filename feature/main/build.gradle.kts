plugins {
    id("chh.android.feature")
}

android {
    namespace = "com.chh.compose.feature.main"
}

dependencies {
    implementation(projects.feature.pokemon)
    implementation(projects.feature.pokemonDetail)
    implementation(projects.feature.type)
    implementation(projects.feature.typeDetail)
}

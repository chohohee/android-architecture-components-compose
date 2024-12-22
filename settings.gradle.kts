pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AAC-Compose"
include(":app")

include(
    ":core:common",
    ":core:data",
    ":core:designsystem",
    ":core:domain",
    ":core:model",
    ":core:navigation",
    ":core:network",
    ":core:ui"
)

include(
    ":feature:main",
    ":feature:pokemon",
    ":feature:pokemon-detail",
    ":feature:type",
    ":feature:type-detail"
)
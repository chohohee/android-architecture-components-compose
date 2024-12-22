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
)

include(
    ":feature:attribute",
    ":feature:main",
    ":feature:pokemon",
    ":feature:pokemon-detail"
)
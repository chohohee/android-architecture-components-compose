package com.chh.compose.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

internal fun Project.configureAndroidCompose() {
    with(plugins) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()
        platformImplementation(platform(bom))
        androidTestPlatformImplementation(platform(bom))

        implementation(libs.findBundle("androidx.compose"))
        testImplementation(libs.findLibrary("junit"))
        androidTestImplementation(libs.findLibrary("androidx.junit"))
        androidTestImplementation(libs.findLibrary("androidx.espresso.core"))
        androidTestImplementation(libs.findLibrary("androidx.ui.test.junit4"))
        debugImplementation(libs.findBundle("androidx.compose.debug"))
    }

    extensions.getByType<ComposeCompilerGradlePluginExtension>().apply {
        includeSourceInformation.set(true)
    }
}

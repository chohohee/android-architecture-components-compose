package com.chh.compose.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import java.util.Optional

internal fun <T> DependencyHandler.implementation(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("implementation", dependencyNotation.get())

internal fun <T> DependencyHandler.testImplementation(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("testImplementation", dependencyNotation.get())

internal fun <T> DependencyHandler.androidTestImplementation(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("androidTestImplementation", dependencyNotation.get())

internal fun <T> DependencyHandler.debugImplementation(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("debugImplementation", dependencyNotation.get())

internal fun <T> DependencyHandler.ksp(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("ksp", dependencyNotation.get())

internal val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun <T> DependencyHandler.platformImplementation(
    dependencyNotation: Provider<T>
): Dependency? = add("implementation", dependencyNotation)

internal fun <T> DependencyHandler.androidTestPlatformImplementation(
    dependencyNotation: Provider<T>
): Dependency? = add("androidTestImplementation", dependencyNotation)

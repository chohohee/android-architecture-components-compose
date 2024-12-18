import com.chh.compose.convention.implementation
import com.chh.compose.convention.libs
import com.chh.compose.convention.projectImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("chh.android.library")
                apply("chh.android.compose")
                apply("chh.hilt.android")
            }

            dependencies {
                projectImplementation(project(":core:designsystem"))
                projectImplementation(project(":core:domain"))
                projectImplementation(project(":core:model"))
                projectImplementation(project(":core:navigation"))

                implementation(libs.findLibrary("androidx.activity.compose"))
                implementation(libs.findLibrary("androidx.navigation.compose"))
                implementation(libs.findLibrary("hilt.navigation.compose"))
            }
        }
    }
}

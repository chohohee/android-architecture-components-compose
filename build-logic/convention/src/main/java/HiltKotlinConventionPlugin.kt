import com.chh.compose.convention.implementation
import com.chh.compose.convention.ksp
import com.chh.compose.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class HiltKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(libs.findLibrary("hilt.core"))
                ksp(libs.findLibrary("hilt.compiler"))
            }
        }
    }
}

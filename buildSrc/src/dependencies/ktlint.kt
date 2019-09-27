import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.register
import org.gradle.language.base.plugins.LifecycleBasePlugin

private const val VERSION_KTLINT: String = "0.34.2"

fun Dependencies.ktlint(module: String? = null) = when (module) {
    null -> "com.pinterest:ktlint:$VERSION_KTLINT"
    else -> "com.pinterest.ktlint:ktlint-$module:$VERSION_KTLINT"
}

fun Project.ktlint(
    extraDependency: (Configuration.(
        add: (dependencyNotation: Any) -> Unit
    ) -> Unit)? = null
) {
    val configuration = configurations.register("ktlint")

    dependencies {
        configuration {
            invoke(ktlint())
            extraDependency?.invoke(this) { dependencyNotation ->
                invoke(dependencyNotation)
            }
        }
    }

    tasks {
        val ktlint = register("ktlint", JavaExec::class) {
            group = LifecycleBasePlugin.VERIFICATION_GROUP
            inputs.dir("src")
            outputs.dir("src")
            description = "Check Kotlin code style."
            classpath(configuration.get())
            main = "com.pinterest.ktlint.Main"
            args("src/**/*.kt")
        }
        "check" {
            dependsOn(ktlint.get())
        }
        register("ktlintFormat", JavaExec::class) {
            group = "formatting"
            inputs.dir("src")
            outputs.dir("src")
            description = "Fix Kotlin code style deviations."
            classpath(configuration.get())
            main = "com.pinterest.ktlint.Main"
            args("-F", "src/**/*.kt")
        }
    }
}
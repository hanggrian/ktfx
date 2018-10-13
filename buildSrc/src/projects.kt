import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.register
import org.gradle.language.base.plugins.LifecycleBasePlugin

fun Project.ktlint(
    extraDependency: Configuration.(
        add: (dependencyNotation: Any) -> Unit
    ) -> Unit
) {
    val configuration = configurations.register("ktlint")

    dependencies {
        configuration {
            invoke(ktlint())
            extraDependency { dependencyNotation ->
                invoke(dependencyNotation)
            }
        }
    }

    tasks {
        register("ktlint", JavaExec::class) {
            "check" {
                dependsOn(this@register)
            }
            group = LifecycleBasePlugin.VERIFICATION_GROUP
            inputs.dir("src")
            outputs.dir("src")
            description = "Check Kotlin code style."
            classpath(configuration)
            main = "com.github.shyiko.ktlint.Main"
            args("src/**/*.kt")
        }
        register("ktlintFormat", JavaExec::class) {
            group = "formatting"
            inputs.dir("src")
            outputs.dir("src")
            description = "Fix Kotlin code style deviations."
            classpath(configuration)
            main = "com.github.shyiko.ktlint.Main"
            args("-F", "src/**/*.kt")
        }
    }
}
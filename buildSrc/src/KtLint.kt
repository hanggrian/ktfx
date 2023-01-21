import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.attributes.Bundling
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.registering
import org.gradle.language.base.plugins.LifecycleBasePlugin

val Project.ktlint: Configuration
    get() {
        var ktlint = configurations.findByName("ktlint")
        if (ktlint == null) {
            ktlint = configurations.create("ktlint")
            val outputDir = "${project.buildDir}/reports/ktlint/"
            val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))
            tasks {
                val ktlintCheck by registering(JavaExec::class) {
                    group = LifecycleBasePlugin.VERIFICATION_GROUP
                    inputs.files(inputFiles)
                    outputs.dir(outputDir)
                    description = "Check Kotlin code style."
                    classpath(ktlint)
                    mainClass.set("com.pinterest.ktlint.Main")
                    args = listOf("src/**/*.kt")
                }
                named("check") {
                    dependsOn(ktlintCheck)
                }
                register<JavaExec>("ktlintFormat") {
                    group = "formatting"
                    inputs.files(inputFiles)
                    outputs.dir(outputDir)
                    description = "Fix Kotlin code style deviations."
                    classpath(ktlint)
                    mainClass.set("com.pinterest.ktlint.Main")
                    args = listOf("-F", "src/**/*.kt")
                }
            }
        }
        return ktlint
    }

fun Project.configureKtlint(dependency: ModuleDependency) {
    dependency.attributes {
        attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
    }
}

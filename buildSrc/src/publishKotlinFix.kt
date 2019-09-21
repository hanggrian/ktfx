import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.get

// temporary fix for empty sources jar https://github.com/novoda/bintray-release/issues/262
// no fix yet to javadoc jar https://github.com/Kotlin/dokka/issues/42
fun Project.publishKotlinFix() {
    tasks.whenTaskAdded {
        if (name == "generateSourcesJarForMavenPublication") {
            this as Jar
            from(project.convention.getPlugin(JavaPluginConvention::class.java).sourceSets["main"].allSource)
        }
    }
}
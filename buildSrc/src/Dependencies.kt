import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

fun DependencyHandler.kotlinx(
    module: String,
    version: String? = null
) = "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

fun DependencyHandler.dokka() = "org.jetbrains.dokka:dokka-gradle-plugin:$dokkaVersion"
inline val PluginDependenciesSpec.dokka get() = id("org.jetbrains.dokka")

fun DependencyHandler.spek(module: String) = "org.jetbrains.spek:spek-$module:$spekVersion"

fun DependencyHandler.junitPlatform(module: String) = "org.junit.platform:junit-platform-$module:$junitPlatformVersion"
inline val PluginDependenciesSpec.`junit-platform` get() = id("org.junit.platform.gradle.plugin")

fun DependencyHandler.testFX(module: String) = "org.testfx:testfx-$module:$testFXVersion"

fun DependencyHandler.bintrayRelease() = "com.novoda:bintray-release:$bintrayReleaseVersion"
inline val PluginDependenciesSpec.`bintray-release` get() = id("com.novoda.bintray-release")

fun DependencyHandler.gitPublish() = "org.ajoberstar:gradle-git-publish:$gitPublishVersion"
inline val PluginDependenciesSpec.`git-publish` get() = id("org.ajoberstar.git-publish")

fun DependencyHandler.ktlint() = "com.github.shyiko:ktlint:$ktlintVersion"
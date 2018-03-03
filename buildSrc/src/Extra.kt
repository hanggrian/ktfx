import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

const val releaseUser = "hendraanggrian"
const val releaseGroup = "com.$releaseUser"
const val releaseArtifact = "kotfx"
const val releaseVersion = "0.35"
const val releaseDesc = "Minimalist JavaFX development with Kotlin"
const val releaseWeb = "https://github.com/$releaseUser/$releaseArtifact"

const val kotlinVersion = "1.2.30"
const val coroutinesVersion = "0.22.3"

fun DependencyHandler.kotlinx(module: String, version: String? = null) = "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" }
    ?: ""}"

fun DependencyHandler.dokka() = "org.jetbrains.dokka:dokka-gradle-plugin:0.9.16"
inline val PluginDependenciesSpec.dokka get() = id("org.jetbrains.dokka")

fun DependencyHandler.ktlint() = "com.github.shyiko:ktlint:0.18.0"

fun DependencyHandler.gitPublish() = "org.ajoberstar:gradle-git-publish:0.3.3"
inline val PluginDependenciesSpec.`git-publish` get() = id("org.ajoberstar.git-publish")

fun DependencyHandler.bintrayRelease() = "com.novoda:bintray-release:0.8.0"
inline val PluginDependenciesSpec.`bintray-release` get() = id("com.novoda.bintray-release")

fun DependencyHandler.spek(module: String) = "org.jetbrains.spek:spek-$module:1.1.5"

fun DependencyHandler.junitPlatform(module: String) = "org.junit.platform:junit-platform-$module:1.0.0"
inline val PluginDependenciesSpec.`junit-platform` get() = id("org.junit.platform.gradle.plugin")

fun DependencyHandler.testFX(module: String) = "org.testfx:testfx-$module:4.0.12-alpha"
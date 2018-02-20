const val releaseUser = "hendraanggrian"
const val releaseGroup = "com.hendraanggrian"
const val releaseArtifact = "kotfx"
const val releaseVersion = "0.26"
const val releaseDesc = "Minimalist JavaFX development"
const val releaseWeb = "https://github.com/$releaseUser/$releaseArtifact"

const val kotlinVersion = "1.2.21"
const val spekVersion = "1.1.5"
const val coroutinesVersion = "0.22.2"
const val junitPlatformVersion = "1.0.0"

fun Dependency.kotlinx(module: String, version: String? = null) = "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" }
    ?: ""}"

fun Dependency.ktlint() = "com.github.shyiko:ktlint:0.15.0"

fun Dependency.dokka() = "org.jetbrains.dokka:dokka-gradle-plugin:0.9.15"
inline val Plugin.dokka get() = id("org.jetbrains.dokka")

fun Dependency.gitPublish() = "org.ajoberstar:gradle-git-publish:0.3.2"
inline val Plugin.`git-publish` get() = id("org.ajoberstar.git-publish")

fun Dependency.bintrayRelease() = "com.novoda:bintray-release:0.8.0"
inline val Plugin.`bintray-release` get() = id("com.novoda.bintray-release")

fun Dependency.junitPlatform(module: String, version: String) = "org.junit.platform:junit-platform-$module:$version"
inline val Plugin.`junit-platform` get() = id("org.junit.platform.gradle.plugin")

fun Dependency.spek(module: String, version: String) = "org.jetbrains.spek:spek-$module:$version"

private typealias Dependency = org.gradle.api.artifacts.dsl.DependencyHandler
private typealias Plugin = org.gradle.plugin.use.PluginDependenciesSpec
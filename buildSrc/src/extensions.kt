import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

const val bintrayUser = "hendraanggrian"
const val bintrayGroup = "com.hendraanggrian"
const val bintrayArtifact = "kotfx"
const val bintrayPublish = "0.14"
const val bintrayDesc = "Minimalist JavaFX development"
const val bintrayWeb = "https://github.com/hendraanggrian/kotfx"

const val kotlinVersion = "1.2.10"
const val dokkaVersion = "0.9.15"
const val bintrayReleaseVersion = "0.8.0"
const val junitVersion = "4.12"

fun DependencyHandler.dokka(version: String) = "org.jetbrains.dokka:dokka-gradle-plugin:$version"
val PluginDependenciesSpec.dokka get() = id("org.jetbrains.dokka")

fun DependencyHandler.bintrayRelease(version: String) = "com.novoda:bintray-release:$version"
val PluginDependenciesSpec.`bintray-release` get() = id("com.novoda.bintray-release")

fun DependencyHandler.junit(version: String) = "junit:junit:$version"
import org.gradle.api.artifacts.dsl.DependencyHandler

const val bintrayUser = "hendraanggrian"
const val bintrayGroup = "com.hendraanggrian"
const val bintrayArtifact = "kotfx"
const val bintrayPublish = "0.7"
const val bintrayDesc = "Lightweight library full of Kotlin extension functions for JavaFX"
const val bintrayWeb = "https://github.com/hendraanggrian/kotfx"

const val kotlinVersion = "1.1.61"
const val junitVersion = "4.12"

fun DependencyHandler.junit(version: String) = "junit:junit:$version"
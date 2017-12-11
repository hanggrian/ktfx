import org.gradle.api.artifacts.dsl.DependencyHandler

const val bintrayUser = "hendraanggrian"
const val bintrayGroup = "com.hendraanggrian"
const val bintrayArtifact = "kotfx"
const val bintrayPublish = "0.8"
const val bintrayDesc = "Minimalist JavaFX development"
const val bintrayWeb = "https://github.com/hendraanggrian/kotfx"

const val kotlinVersion = "1.1.61"
const val junitVersion = "4.12"

fun DependencyHandler.junit(version: String) = "junit:junit:$version"
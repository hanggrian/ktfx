val releaseArtifact: String by project

plugins {
    alias(libs.plugins.javafx)
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.maven.publish)
}

javafx.modules("javafx.controls")

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$releaseArtifact-layouts"))
    implementation(libs.jfoenix)

    testImplementation(project(":testing:layouts"))
}

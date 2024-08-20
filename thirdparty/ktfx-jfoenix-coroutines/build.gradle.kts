val releaseArtifact: String by project

plugins {
    alias(libs.plugins.javafx)
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.maven.publish)
}

javafx.modules("javafx.controls", "javafx.swing")

kotlin.explicitApi()

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$releaseArtifact-coroutines"))
    implementation(libs.kotlinx.coroutines.javafx)
    implementation(libs.jfoenix)

    testImplementation(project(":testing:coroutines"))
}

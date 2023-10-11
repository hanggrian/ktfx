val RELEASE_ARTIFACT: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.maven.publish)
}

dependencies {
    ktlintRuleset(libs.ktlint)
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$RELEASE_ARTIFACT-coroutines"))
    implementation(libs.kotlinx.coroutines.javafx)
    implementation(libs.controlsfx)

    testImplementation(project(":testing:listeners-controlsfx"))
}

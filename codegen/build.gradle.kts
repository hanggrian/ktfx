val releaseGroup: String by project

plugins {
    alias(libs.plugins.javafx)
    application
    kotlin("jvm")
    alias(libs.plugins.ktlint)
}

javafx.modules("javafx.controls", "javafx.web")

application.mainClass.set("$releaseGroup.codegen.Generator")

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(kotlin("reflect", libs.versions.kotlin.get()))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinpoet.dsl)
    implementation(libs.controlsfx)
    implementation(libs.jfoenix)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
}

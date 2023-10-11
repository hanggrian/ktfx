val RELEASE_GROUP: String by project

plugins {
    application
    kotlin("jvm")
    alias(libs.plugins.ktlint)
}

application.mainClass.set("$RELEASE_GROUP.codegen.Generator")

dependencies {
    ktlintRuleset(libs.ktlint)
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(kotlin("reflect", libs.versions.kotlin.get()))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinpoet.dsl)
    implementation(libs.controlsfx)
    implementation(libs.jfoenix)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
}

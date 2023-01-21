plugins {
    application
    kotlin("jvm")
}

application.mainClass.set("$RELEASE_GROUP.codegen.Generator")

dependencies {
    ktlint(libs.ktlint, ::configureKtlint)
    ktlint(libs.rulebook.ktlint)
    implementation(kotlin("reflect", libs.versions.kotlin.get()))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinpoet.dsl)
    implementation(libs.controlsfx)
    implementation(libs.jfoenix)
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
}

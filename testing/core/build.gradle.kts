plugins {
    alias(libs.plugins.javafx)
    kotlin("jvm")
    alias(libs.plugins.ktlint)
}

javafx.modules("javafx.controls")

dependencies {
    api(kotlin("test-junit", libs.versions.kotlin.get()))
    api(libs.kotlinx.coroutines.javafx)
    api(libs.truth)
    api(libs.bundles.testfx)
}

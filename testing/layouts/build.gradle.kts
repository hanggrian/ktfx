plugins {
    alias(libs.plugins.javafx)
    kotlin("jvm")
    alias(libs.plugins.ktlint)
}

javafx.modules("javafx.controls")

dependencies.api(project(":testing:core"))

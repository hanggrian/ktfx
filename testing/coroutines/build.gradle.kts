plugins {
    alias(libs.plugins.javafx)
    kotlin("jvm")
    alias(libs.plugins.ktlint)
}

javafx.modules("javafx.controls", "javafx.web")

dependencies.api(project(":testing:core"))

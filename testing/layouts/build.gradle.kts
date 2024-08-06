plugins {
    kotlin("jvm")
    alias(libs.plugins.ktlint)
}

dependencies.api(project(":testing:core"))

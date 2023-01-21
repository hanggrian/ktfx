plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":testing:listeners"))
    api(libs.controlsfx)
}

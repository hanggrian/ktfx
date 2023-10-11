plugins {
    kotlin("jvm")
}

dependencies {
    api(kotlin("test-junit", libs.versions.kotlin.get()))
    api(libs.kotlinx.coroutines.javafx)
    api(libs.truth)
    api(libs.testfx.junit)
    api(libs.testfx.monocle)
}

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

dependencies {
    api(project(":thirdparty:controlsfx-commons"))
    api(project(":thirdparty:controlsfx-layouts"))
    api(project(":thirdparty:controlsfx-coroutines"))
}

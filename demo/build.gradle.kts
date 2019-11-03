plugins {
    java
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    implementation(project(":ktfx"))
    implementation(project(":ktfx-features:controlsfx"))
    implementation(project(":ktfx-features:jfoenix"))
}
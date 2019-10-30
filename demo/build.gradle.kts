plugins {
    java
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    implementation(project(":ktfx"))
    implementation(project(":ktfx-thirdparty:controlsfx"))
    implementation(project(":ktfx-thirdparty:jfoenix"))
}
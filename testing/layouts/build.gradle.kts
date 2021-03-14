plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
    }
}

dependencies {
    api(project(":testing:core"))
}
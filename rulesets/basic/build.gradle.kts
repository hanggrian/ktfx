plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
        resources.srcDir("res")
    }
    getByName("test") {
        java.srcDir("tests/src")
    }
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("test-junit", VERSION_KOTLIN))
    implementation(ktlint("core"))
    testImplementation(project(":testing:ruleset"))
}
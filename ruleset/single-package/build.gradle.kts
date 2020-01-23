plugins {
    kotlin("jvm")
    idea
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
        resources.srcDir("res")   
    }
    get("test").java.srcDir("tests/src")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("test-junit", VERSION_KOTLIN))
    implementation(ktlint("core"))

    testImplementation(project(":testing:ruleset"))
}
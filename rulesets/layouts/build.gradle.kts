plugins {
    kotlin("jvm")
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")   
    }
    test {
        java.srcDir("tests/src")
    }
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("test-junit", VERSION_KOTLIN))
    implementation(ktlint("core"))
    testImplementation(project(":testing:ruleset"))
}
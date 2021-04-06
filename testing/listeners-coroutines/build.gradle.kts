plugins {
    kotlin("jvm")
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")
    }
}

dependencies {
    api(project(":testing:core"))
}
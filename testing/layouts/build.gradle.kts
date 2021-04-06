plugins {
    kotlin("jvm")
}

sourceSets {
    main {
        java.srcDir("src")
    }
}

dependencies {
    api(project(":testing:core"))
}
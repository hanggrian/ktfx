plugins {
    kotlin("jvm")
}

sourceSets {
    main {
        java.srcDir("src")
    }
}

dependencies {
    implementation(project(":testing:core"))
}

plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(project(":testing:core"))
    api(testFx("junit5"))
    api(junit("jupiter-api", VERSION_JUNIT_JUPITER))
    api(junit("jupiter-engine", VERSION_JUNIT_JUPITER))
}
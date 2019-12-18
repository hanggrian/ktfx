plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(project(":testing:core"))
    api(testFx("testfx-junit5", VERSION_TESTFX))
    api(testFx("openjfx-monocle", VERSION_MONOCLE))
    api(junit("jupiter-api", VERSION_JUNIT_JUPITER))
    api(junit("jupiter-engine", VERSION_JUNIT_JUPITER))
}
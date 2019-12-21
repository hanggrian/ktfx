plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(project(":testing:core"))
    api(testFx("testfx-junit", VERSION_TESTFX))
    api(testFx("openjfx-monocle", VERSION_MONOCLE))
    api(junit())
}
plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(project(":testing:core"))
    api(testFx("core"))
    api(testFx("junit"))
}
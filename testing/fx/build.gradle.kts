plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    compile(project(":testing:core"))
    compile(testFx("core"))
    compile(testFx("junit"))
}
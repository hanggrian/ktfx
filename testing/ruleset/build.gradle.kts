plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(project(":testing:core"))
    api(project(":ruleset:core"))
    api(ktlint("core"))
    api(ktlint("test"))
}
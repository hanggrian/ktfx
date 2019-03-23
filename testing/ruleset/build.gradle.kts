plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    compile(project(":testing:core"))
    compile(project(":ruleset:core"))
    compile(ktlint("core"))
    compile(ktlint("test"))
}
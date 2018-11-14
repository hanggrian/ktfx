plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    compile(project(":testing:core"))
    compile(project(":ruleset:core"))
    compile(ktlint("core"))
    compile(ktlint("test"))
}
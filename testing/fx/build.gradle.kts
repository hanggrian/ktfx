plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    compile(project(":testing:core"))
    compile(testFx("core"))
    compile(testFx("junit"))
}
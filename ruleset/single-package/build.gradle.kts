plugins {
    kotlin("jvm")
    idea
}

sourceSets {
    get("main").java.srcDir("src")
    get("main").resources.srcDir("res")
    get("test").java.srcDir("tests/src")
}

dependencies {
    compile(project(":ruleset:core"))

    testImplementation(project(":testing:ruleset"))
}
group = "$RELEASE_GROUP.rules"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
    get("main").resources.srcDir("res")
    get("test").java.srcDir("tests/src")
}

dependencies {
    compile(project(":$RULESET"))

    testImplementation(project(":$TESTING_RULESET"))
}
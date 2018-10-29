group = "$RELEASE_GROUP.test"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    compile(project(":$ARTIFACT_DEV_TESTING_CORE"))
    compile(project(":$ARTIFACT_DEV_RULESET_CORE"))
    compile(ktlint("core"))
    compile(ktlint("test"))
}
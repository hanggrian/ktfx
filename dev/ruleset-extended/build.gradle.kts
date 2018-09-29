group = "$RELEASE_GROUP.rules"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    idea
    buildconfig
}

sourceSets {
    get("main").java.srcDir("src")
    get("main").resources.srcDir("res")
    get("test").java.srcDir("tests/src")
}

dependencies {
    compile(project(":$ARTIFACT_DEV_RULESET"))

    testImplementation(project(":$ARTIFACT_DEV_TESTING_RULESET"))
}

tasks.withType<com.hendraanggrian.generation.buildconfig.BuildConfigTask> {
    field("ARTIFACT_COROUTINES", ARTIFACT_COROUTINES)
    field("ARTIFACT_LAYOUTS", ARTIFACT_LAYOUTS)
    field("ARTIFACT_LISTENERS", ARTIFACT_LISTENERS)
    field("ARTIFACT_STYLES", ARTIFACT_STYLES)
    field("ARTIFACT_THIRDPARTY_CONTROLSFX", ARTIFACT_THIRDPARTY_CONTROLSFX)
    field("ARTIFACT_THIRDPARTY_JFOENIX", ARTIFACT_THIRDPARTY_JFOENIX)
}
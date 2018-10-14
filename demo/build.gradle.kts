group = "$RELEASE_GROUP.demo"
version = RELEASE_VERSION

plugins {
    java
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

kotlin.experimental.coroutines = org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
    ARTIFACTS_THIRDPARTY.forEach {
        implementation(project(":$it"))
    }
}
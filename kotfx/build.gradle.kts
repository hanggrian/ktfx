import org.gradle.kotlin.dsl.kotlin

plugins {
    `java-library`
    kotlin("jvm")
    id("com.novoda.bintray-release")
}

java.sourceSets {
    getByName("main").java.srcDirs("src")
    getByName("test").java.srcDirs("tests/src")
}

dependencies {
    compile(kotlin("stdlib", kotlinVersion))
    testImplementation(junit(junitVersion))
}

publish {
    userOrg = bintrayUser
    groupId = bintrayGroup
    artifactId = bintrayArtifact
    publishVersion = bintrayPublish
    desc = bintrayDesc
    website = bintrayWeb
}
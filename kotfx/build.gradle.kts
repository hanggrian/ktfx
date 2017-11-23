import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.setValue

plugins {
    `java-library`
    kotlin("jvm")
    id("com.novoda.bintray-release")
}

dependencies {
    compile(kotlin("stdlib", kotlinVersion))
    testImplementation("junit:junit:$junitVersion")
}

publish {
    userOrg = bintrayUser
    groupId = bintrayGroup
    artifactId = bintrayArtifact
    publishVersion = bintrayPublish
    desc = bintrayDesc
    website = bintrayWeb
}
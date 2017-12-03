plugins {
    `java-library`
    kotlin("jvm")
    id("com.novoda.bintray-release")
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
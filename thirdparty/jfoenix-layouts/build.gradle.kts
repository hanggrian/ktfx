import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `bintray-release`
}

sourceSets {
    get("main").java.srcDir("src")
    get("test").java.srcDir("tests/src")
}

ktlint { add ->
    add(project(":rulesets:basic"))
    add(project(":rulesets:non-commons"))
    add(project(":rulesets:layouts"))
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-layouts"))
    api(jfoenix())

    testImplementation(project(":testing:layouts"))
}

tasks {
    withType<KotlinCompile> { kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn") }
    dokkaHtml.configure {
        dokkaSourceSets {
            named("main") {
                moduleDisplayName.set("$RELEASE_ARTIFACT-jfoenix-layouts")
                sourceLink {
                    localDirectory.set(file("src"))
                    remoteUrl.set(github("thirdparty/jfoenix-layouts"))
                    remoteLineSuffix.set("#L")
                }
            }
        }
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-jfoenix-layouts"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}

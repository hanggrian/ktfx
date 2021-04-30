buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka)
        classpath(`git-publish`)
    }
}

allprojects {
    repositories {
        jcenter() // TestFX hasn't migrated
        mavenCentral()
        maven(REPOSITORIES_OSSRH_SNAPSHOTS)
    }
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions { jvmTarget = "1.8" }
        }
    }
}
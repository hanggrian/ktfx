buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(javafx)
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
}
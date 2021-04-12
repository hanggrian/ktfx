buildscript {
    repositories {
        mavenCentral()
        maven(REPOSITORIES_GIT_PUBLISH)
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
    }
}

allprojects {
    repositories {
        jcenter() // TestFX hasn't migrated
        mavenCentral()
        maven(REPOSITORIES_OSSRH_SNAPSHOTS)
    }
    tasks {
        withType<Delete> {
            delete(projectDir.resolve("out"))
        }
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions { jvmTarget = "1.8" }
        }
    }
}
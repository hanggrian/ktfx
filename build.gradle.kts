buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
    }
}

allprojects {
    repositories {
        jcenter()
        maven(REPO_OSSRH_SNAPSHOTS)
    }
    tasks {
        withType<Delete> { delete(projectDir.resolve("out")) }
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions { jvmTarget = "1.8" } }
    }
}
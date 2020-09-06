import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
        classpath(bintrayRelease())
    }
}

allprojects {
    repositories {
        jcenter()
    }
    tasks {
        withType<Delete> { delete(projectDir.resolve("out")) }
        withType<KotlinCompile> { kotlinOptions { jvmTarget = "1.8" } }
    }
}

tasks.register<Delete>("clean") {
    delete(buildDir)
}

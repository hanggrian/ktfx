buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
        classpath(bintray())
        classpath(bintrayRelease())
    }
}

allprojects {
    repositories {
        jcenter()
    }
    tasks.withType<Delete> {
        delete(projectDir.resolve("out"))
    }
}

tasks {
    register("clean", Delete::class) {
        delete(buildDir)
    }
    register("wrapper", Wrapper::class) {
        gradleVersion = VERSION_GRADLE
    }
}
import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.kotlin
import java.io.File

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
        classpath(bintrayRelease())
        classpath(junitPlatform("gradle-plugin"))
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
    "clean"(Delete::class) {
        delete(buildDir)
    }
    "wrapper"(Wrapper::class) {
        gradleVersion = VERSION_GRADLE
    }
}

/** bintray upload snippet
./gradlew bintrayUpload -PdryRun=false -PbintrayUser=hendraanggrian -PbintrayKey=
 */
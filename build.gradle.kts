import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.kotlin
import java.io.File

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath(dokka())
        classpath(bintrayRelease())
        classpath(junitPlatform("gradle-plugin", junitPlatformVersion))
    }
}

allprojects {
    repositories {
        jcenter()
    }
    tasks.withType(Delete::class.java) {
        delete(File(projectDir, "out"))
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

task<Wrapper>("wrapper"){
    gradleVersion = "4.5.1"
}

/** QUICK UPLOAD
./gradlew bintrayUpload -PdryRun=false -PbintrayUser=hendraanggrian -PbintrayKey=
 */
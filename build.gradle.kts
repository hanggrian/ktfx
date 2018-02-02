import org.gradle.kotlin.dsl.kotlin

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

/** QUICK UPLOAD
./gradlew bintrayUpload -PdryRun=false -PbintrayUser=hendraanggrian -PbintrayKey=
 */
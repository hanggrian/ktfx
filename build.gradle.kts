buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath(bintrayRelease(bintrayReleaseVersion))
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

/** QUICK UPLOAD
./gradlew bintrayUpload -PdryRun=false -PbintrayUser=hendraanggrian -PbintrayKey=
 */
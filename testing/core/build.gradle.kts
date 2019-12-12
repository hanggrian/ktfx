plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlin("test-junit5", VERSION_KOTLIN))
    api(google("truth", "truth", VERSION_TRUTH))
}
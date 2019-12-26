plugins {
    kotlin("jvm")
}

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlin("test-junit", VERSION_KOTLIN))
    api(google("truth", "truth", VERSION_TRUTH))
}
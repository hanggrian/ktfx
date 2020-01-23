plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("test-junit", VERSION_KOTLIN))
    implementation(google("truth", "truth", VERSION_TRUTH))

    implementation(ktlint("core"))
    implementation(ktlint("test"))
}
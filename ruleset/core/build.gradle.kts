plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(ktlint("core"))
}
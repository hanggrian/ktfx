plugins {
    kotlin("jvm")
}

sourceSets["main"].java.srcDir("src")

dependencies {
    compile(kotlin("stdlib", VERSION_KOTLIN))
    compile(ktlint("core"))
}
group = "$RELEASE_GROUP.rules"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    compile(kotlin("stdlib", VERSION_KOTLIN))
    compile(ktlint("core"))
}
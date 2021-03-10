plugins {
    kotlin("jvm")
    application
}

application.mainClass.set("io.github.hendraanggrian.ktfx.codegen.Generator")

sourceSets {
    get("main").java.srcDir("src")
    get("test").java.srcDir("tests/src")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlin("reflect", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    implementation(kotlinpoetKtx())
    implementation(controlsfx())
    implementation(jfoenix())

    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
}
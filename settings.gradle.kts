pluginManagement.repositories {
    mavenCentral()
    gradlePluginPortal()
}
dependencyResolutionManagement.repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

rootProject.name = "ktfx"

include("ktfx", "ktfx-commons", "ktfx-coroutines", "ktfx-layouts")
include("codegen")
include("sample")
include("website")

includeDir("thirdparty")
includeDir("testing")

fun includeDir(dir: String) = include(*file(dir).listFiles()!!
    .filter { it.isDirectory }
    .map { "$dir:${it.name}" }
    .toTypedArray())

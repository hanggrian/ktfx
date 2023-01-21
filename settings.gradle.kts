pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
}
dependencyResolutionManagement.repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

rootProject.name = "ktfx"

include("ktfx", "ktfx-commons", "ktfx-coroutines", "ktfx-layouts", "ktfx-listeners")
include("codegen")
include("sample")
include("website")

includeDir("thirdparty")
includeDir("testing")

fun includeDir(dir: String) = file(dir).listFiles()
    .filter { it.isDirectory }
    .forEach { include("$dir:${it.name}") }

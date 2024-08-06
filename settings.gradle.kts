pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
}
dependencyResolutionManagement.repositories.mavenCentral()

rootProject.name = "ktfx"

include("ktfx", "ktfx-commons", "ktfx-coroutines", "ktfx-layouts")
include("codegen")
include("sample")
include("website")

includeDir("thirdparty")
includeDir("testing")

fun includeDir(dir: String) =
    include(
        *file(dir)
            .listFiles()!!
            .filter { it.isDirectory }
            .map { "$dir:${it.name}" }
            .toTypedArray(),
    )

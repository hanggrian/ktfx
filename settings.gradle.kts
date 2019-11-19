include("ktfx")
include("ktfx-commons")
include("ktfx-core")
include("ktfx-coroutines")
include("ktfx-layouts")
include("ktfx-listeners")
includeDir("ktfx-features")

include("website")
include("demo")

includeDir("ruleset")
includeDir("testing")

fun includeDir(dir: String) = file(dir)
    .listFiles()
    ?.filter { it.isDirectory }
    ?.forEach { include("$dir:${it.name}") }
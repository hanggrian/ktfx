include("ktfx-core")
include("ktfx-commons")
include("ktfx-layouts")
include("ktfx-listeners")
include("ktfx-coroutines")
include("ktfx")

includeDir("ktfx-features")

include("website")
include("demo")

includeDir("ruleset")
includeDir("testing")

fun includeDir(dir: String) = file(dir)
    .listFiles()
    ?.filter { it.isDirectory }
    ?.forEach { include("$dir:${it.name}") }
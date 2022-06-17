include("ktfx-commons")
include("ktfx-layouts")
include("ktfx-listeners")
include("ktfx-coroutines")
include("ktfx")

includeDir("thirdparty")
includeDir("rulesets")
includeDir("testing")

include("codegen")
include("website")
include("sample")

fun includeDir(dir: String) = file(dir)
    .listFiles()!!
    .filter { it.isDirectory }
    .forEach { include("$dir:${it.name}") }
    
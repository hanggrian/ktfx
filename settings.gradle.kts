include(RELEASE_ARTIFACT)
include("$RELEASE_ARTIFACT-commons")
include("$RELEASE_ARTIFACT-core")
include("$RELEASE_ARTIFACT-coroutines")
include("$RELEASE_ARTIFACT-layouts")
include("$RELEASE_ARTIFACT-listeners")

includeDir("$RELEASE_ARTIFACT-test")
includeDir("$RELEASE_ARTIFACT-thirdparty")

//include("website")
//include("demo")

includeDir("ruleset")
includeDir("testing")

fun includeDir(dir: String) = file(dir).walkEach { include("$dir:${it.name}") }

fun File.walkEach(
    filter: (File) -> Boolean = { it.isDirectory },
    forEach: (File) -> Unit
) = listFiles()?.filter(filter)?.forEach(forEach)
include(RELEASE_ARTIFACT)
include("$RELEASE_ARTIFACT-commons")
include("$RELEASE_ARTIFACT-core")
include("$RELEASE_ARTIFACT-coroutines")
include("$RELEASE_ARTIFACT-layouts")
include("$RELEASE_ARTIFACT-listeners")

//include("website")
//include("demo")

includeAll("test")
includeAll("thirdparty")
fun includeAll(module: String) = file("$RELEASE_ARTIFACT-$module").walkEach { dir ->
    dir.walkEach { innerDir ->
        include("$RELEASE_ARTIFACT-$module:${dir.name}:${innerDir.name}")
    }
}

includeDir("ruleset")
includeDir("testing")
fun includeDir(dir: String) = file(dir).walkEach { include("$dir:${it.name}") }

fun File.walkEach(
    filter: (File) -> Boolean = { it.isDirectory },
    forEach: (File) -> Unit
) = listFiles()?.filter(filter)?.forEach(forEach)
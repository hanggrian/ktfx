const val VERSION_KOTLIN = "1.4.30"
const val VERSION_DOKKA = "1.4.20"
const val VERSION_COROUTINES = "1.4.3"

fun org.gradle.api.artifacts.dsl.DependencyHandler.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"

fun org.gradle.api.artifacts.dsl.DependencyHandler.dokka() =
    "org.jetbrains.dokka:dokka-gradle-plugin:$VERSION_DOKKA"

val org.gradle.plugin.use.PluginDependenciesSpec.dokka
    get() = id("org.jetbrains.dokka")
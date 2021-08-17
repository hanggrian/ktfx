internal typealias Plugins = org.gradle.plugin.use.PluginDependenciesSpec
internal typealias Dependencies = org.gradle.api.artifacts.dsl.DependencyHandler

const val VERSION_KOTLIN = "1.5.21"
const val VERSION_COROUTINES = "1.5.1"
val Dependencies.dokka get() = "org.jetbrains.dokka:dokka-gradle-plugin:1.5.0"
val Plugins.dokka get() = id("org.jetbrains.dokka")
fun Dependencies.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"

val Dependencies.`git-publish` get() = "org.ajoberstar:gradle-git-publish:2.1.3"
val Plugins.`git-publish` get() = id("org.ajoberstar.git-publish")

const val VERSION_COMMONS_LANG = "3.11"
fun Dependencies.apache(module: String, version: String): String {
    require('-' in module) { "Module must contain `-` (e.g.: commons-lang, commons-math)." }
    return "org.apache.${module.split('-').first()}:$module:$version"
}

fun Dependencies.controlsfx() = "org.controlsfx:controlsfx:8.40.17"
fun Dependencies.jfoenix() = "com.jfoenix:jfoenix:8.0.7"

const val VERSION_TRUTH = "1.1.3"
fun Dependencies.google(repo: String? = null, module: String, version: String) =
    "com.google${repo?.let { ".$it" }.orEmpty()}:$module:$version"

fun Dependencies.kotlinpoetKtx() = "com.hendraanggrian:kotlinpoet-ktx:0.1-SNAPSHOT"

const val VERSION_MONOCLE = "8u76-b04"
fun Dependencies.testFx(module: String, version: String = "4.0.16-alpha") = "org.testfx:$module:$version"
fun Dependencies.junit() = "junit:junit:4.13-beta-3"
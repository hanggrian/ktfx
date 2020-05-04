const val VERSION_COMMONS_LANG = "3.10"

fun Dependencies.apache(module: String, version: String): String {
    require('-' in module) { "Module must contain `-` (e.g.: commons-lang, commons-math)." }
    return "org.apache.${module.split('-').first()}:$module:$version"
}
package ktfx.styles

class NumberAxisStyleBuilder(prettyPrint: Boolean) : ValueAxisStyleBuilder(prettyPrint) {

    /** The value between each major tick mark in data units. */
    var tickUnit: Number by map
}

inline fun numberAxisStyle(
    prettyPrint: Boolean = false,
    builder: NumberAxisStyleBuilder.() -> Unit
): String = NumberAxisStyleBuilder(prettyPrint).apply(builder).toString()
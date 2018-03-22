package ktfx.styles

class NumberAxisStyleBuilder : ValueAxisStyleBuilder() {

    /** The value between each major tick mark in data units. */
    var tickUnit: Number by map
}

inline fun numberAxisStyle(builder: NumberAxisStyleBuilder.() -> Unit): String =
    NumberAxisStyleBuilder().apply(builder).toString()
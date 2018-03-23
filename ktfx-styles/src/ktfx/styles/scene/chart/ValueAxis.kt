package ktfx.styles

open class ValueAxisStyleBuilder(prettyPrint: Boolean) : AxisStyleBuilder(prettyPrint) {

    var minorTickLength: Number by map

    var minorTickCount: Number by map

    var minorTickVisible: Boolean by map
}

inline fun valueAxisStyle(
    prettyPrint: Boolean = false,
    builder: ValueAxisStyleBuilder.() -> Unit
): String = ValueAxisStyleBuilder(prettyPrint).apply(builder).toString()
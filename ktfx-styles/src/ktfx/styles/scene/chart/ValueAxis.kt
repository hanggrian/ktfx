package ktfx.styles

open class ValueAxisStyleBuilder : AxisStyleBuilder() {

    var minorTickLength: Number by map

    var minorTickCount: Number by map

    var minorTickVisible: Boolean by map
}

inline fun valueAxisStyle(builder: ValueAxisStyleBuilder.() -> Unit): String =
    ValueAxisStyleBuilder().apply(builder).toString()
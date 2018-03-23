package ktfx.styles

interface ValueAxisStyleBuilder {

    var minorTickLength: Number

    var minorTickCount: Number

    var minorTickVisible: Boolean
}

@Suppress("ClassName")
open class _ValueAxisStyleBuilder(
    prettyPrint: Boolean
) : _AxisStyleBuilder(prettyPrint), ValueAxisStyleBuilder {
    override var minorTickLength: Number by map
    override var minorTickCount: Number by map
    override var minorTickVisible: Boolean by map
}

inline fun valueAxisStyle(
    prettyPrint: Boolean = false,
    builder: ValueAxisStyleBuilder.() -> Unit
): String = _ValueAxisStyleBuilder(prettyPrint).apply(builder).toString()
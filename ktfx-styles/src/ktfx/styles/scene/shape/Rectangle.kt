package ktfx.styles

class RectangleStyleBuilder(prettyPrint: Boolean) : NodeStyleBuilder(prettyPrint) {

    var arcHeight: Number by map

    var arcWidth: Number by map
}

inline fun rectangleStyle(
    prettyPrint: Boolean = false,
    builder: RectangleStyleBuilder.() -> Unit
): String = RectangleStyleBuilder(prettyPrint).apply(builder).toString()
package ktfx.styles

class RectangleStyleBuilder : NodeStyleBuilder() {

    var arcHeight: Number by map

    var arcWidth: Number by map
}

inline fun rectangleStyle(builder: RectangleStyleBuilder.() -> Unit): String =
    RectangleStyleBuilder().apply(builder).toString()
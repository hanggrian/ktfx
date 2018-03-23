package ktfx.styles

interface RectangleStyleBuilder {

    var arcHeight: Number

    var arcWidth: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _RectangleStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), RectangleStyleBuilder {
    override var arcHeight: Number by map
    override var arcWidth: Number by map
}

inline fun rectangleStyle(
    prettyPrint: Boolean = false,
    builder: RectangleStyleBuilder.() -> Unit
): String = _RectangleStyleBuilder(prettyPrint).apply(builder).toString()
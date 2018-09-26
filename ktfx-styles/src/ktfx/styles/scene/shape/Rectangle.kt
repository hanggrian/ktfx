@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _RectangleStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), RectangleStyleBuilder {
    override var arcHeight: Number by map
    override var arcWidth: Number by map
}

interface RectangleStyleBuilder {

    var arcHeight: Number

    var arcWidth: Number
}

inline fun rectangleStyle(
    prettyPrint: Boolean = false,
    builder: RectangleStyleBuilder.() -> Unit
): String = _RectangleStyleBuilder(prettyPrint).apply(builder).toString()
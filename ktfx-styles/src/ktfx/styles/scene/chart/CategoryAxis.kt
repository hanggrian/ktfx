@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _CategoryAxisStyleBuilder(
    prettyPrint: Boolean
) : _AxisStyleBuilder(prettyPrint), CategoryAxisStyleBuilder {
    override var startMargin: Number by map
    override var endMargin: Number by map
    override var gapStartAndEnd: Boolean by map
}

interface CategoryAxisStyleBuilder {

    /** The margin between the axis start and the first tick-mark. */
    var startMargin: Number

    /** The margin between the axis start and the first tick-mark. */
    var endMargin: Number

    /** If this is true then half the space between ticks is left at the start and end. */
    var gapStartAndEnd: Boolean
}

inline fun categoryAxisStyle(
    prettyPrint: Boolean = false,
    builder: CategoryAxisStyleBuilder.() -> Unit
): String = _CategoryAxisStyleBuilder(prettyPrint).apply(builder).toString()
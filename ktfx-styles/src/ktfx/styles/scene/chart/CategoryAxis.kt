package ktfx.styles

import ktfx.styles.internal._CategoryAxisStyleBuilder

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
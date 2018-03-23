package ktfx.styles

class CategoryAxisStyleBuilder(prettyPrint: Boolean) : AxisStyleBuilder(prettyPrint) {

    /** The margin between the axis start and the first tick-mark. */
    var startMargin: Number by map

    /** The margin between the axis start and the first tick-mark. */
    var endMargin: Number by map

    /** If this is true then half the space between ticks is left at the start and end. */
    var gapStartAndEnd: Boolean by map
}

inline fun categoryAxisStyle(
    prettyPrint: Boolean = false,
    builder: CategoryAxisStyleBuilder.() -> Unit
): String = CategoryAxisStyleBuilder(prettyPrint).apply(builder).toString()
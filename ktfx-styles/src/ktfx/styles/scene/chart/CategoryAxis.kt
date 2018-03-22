package ktfx.styles

class CategoryAxisStyleBuilder : AxisStyleBuilder() {

    /** The margin between the axis start and the first tick-mark. */
    var startMargin: Number by map

    /** The margin between the axis start and the first tick-mark. */
    var endMargin: Number by map

    /** If this is true then half the space between ticks is left at the start and end. */
    var gapStartAndEnd: Boolean by map
}

inline fun categoryAxisStyle(builder: CategoryAxisStyleBuilder.() -> Unit): String =
    CategoryAxisStyleBuilder().apply(builder).toString()
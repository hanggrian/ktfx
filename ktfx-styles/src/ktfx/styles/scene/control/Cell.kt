package ktfx.styles

open class CellStyleBuilder(prettyPrint: Boolean) : LabeledStyleBuilder(prettyPrint) {

    /**
     * The cell size.
     * For vertical ListView or a TreeView or TableView this is the height, for a horizontal ListView this is the width.
     */
    var cellSize: Number by map
}

inline fun cellStyle(
    prettyPrint: Boolean = false,
    builder: CellStyleBuilder .() -> Unit
): String = CellStyleBuilder(prettyPrint).apply(builder).toString()
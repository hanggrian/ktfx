package ktfx.styles

class CellStyleBuilder : LabeledStyleBuilder() {

    /**
     * The cell size.
     * For vertical ListView or a TreeView or TableView this is the height, for a horizontal ListView this is the width.
     */
    var cellSize: Number by map
}

inline fun cellStyle(builder: CellStyleBuilder .() -> Unit): String =
    CellStyleBuilder().apply(builder).toString()
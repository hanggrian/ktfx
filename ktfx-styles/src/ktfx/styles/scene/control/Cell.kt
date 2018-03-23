package ktfx.styles

interface CellStyleBuilder {

    /**
     * The cell size.
     * For vertical ListView or a TreeView or TableView this is the height, for a horizontal ListView this is the width.
     */
    var cellSize: Number
}

@Suppress("ClassName")
open class _CellStyleBuilder(prettyPrint: Boolean) : _LabeledStyleBuilder(prettyPrint), CellStyleBuilder {
    override var cellSize: Number by map
}

inline fun cellStyle(
    prettyPrint: Boolean = false,
    builder: CellStyleBuilder .() -> Unit
): String = _CellStyleBuilder(prettyPrint).apply(builder).toString()
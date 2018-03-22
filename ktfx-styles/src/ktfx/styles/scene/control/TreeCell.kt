package ktfx.styles

class TreeCellStyleBuilder : CellStyleBuilder() {

    /** The amout of space to multiply by the treeItem.level to get the left margin. */
    var indent: Number by map
}

inline fun treeCellStyle(builder: TreeCellStyleBuilder .() -> Unit): String =
    TreeCellStyleBuilder().apply(builder).toString()
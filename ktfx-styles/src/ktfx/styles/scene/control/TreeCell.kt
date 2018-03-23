package ktfx.styles

class TreeCellStyleBuilder(prettyPrint: Boolean) : CellStyleBuilder(prettyPrint) {

    /** The amout of space to multiply by the treeItem.level to get the left margin. */
    var indent: Number by map
}

inline fun treeCellStyle(
    prettyPrint: Boolean = false,
    builder: TreeCellStyleBuilder .() -> Unit
): String = TreeCellStyleBuilder(prettyPrint).apply(builder).toString()
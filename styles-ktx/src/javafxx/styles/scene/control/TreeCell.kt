package javafxx.styles

import javafxx.styles.internal._TreeCellStyleBuilder

interface TreeCellStyleBuilder {

    /** The amout of space to multiply by the treeItem.level to get the left margin. */
    var indent: Number
}

inline fun treeCellStyle(
    prettyPrint: Boolean = false,
    builder: TreeCellStyleBuilder .() -> Unit
): String = _TreeCellStyleBuilder(prettyPrint).apply(builder).toString()
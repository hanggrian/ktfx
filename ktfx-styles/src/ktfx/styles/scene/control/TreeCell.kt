package ktfx.styles

interface TreeCellStyleBuilder {

    /** The amout of space to multiply by the treeItem.level to get the left margin. */
    var indent: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _TreeCellStyleBuilder(prettyPrint: Boolean) : _CellStyleBuilder(prettyPrint), TreeCellStyleBuilder {
    override var indent: Number by map
}

inline fun treeCellStyle(
    prettyPrint: Boolean = false,
    builder: TreeCellStyleBuilder .() -> Unit
): String = _TreeCellStyleBuilder(prettyPrint).apply(builder).toString()
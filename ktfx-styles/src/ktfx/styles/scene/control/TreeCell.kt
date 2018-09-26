@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _TreeCellStyleBuilder(
    prettyPrint: Boolean
) : _CellStyleBuilder(prettyPrint), TreeCellStyleBuilder {
    override var indent: Number by map
}

interface TreeCellStyleBuilder {

    /** The amout of space to multiply by the treeItem.level to get the left margin. */
    var indent: Number
}

inline fun treeCellStyle(
    prettyPrint: Boolean = false,
    builder: TreeCellStyleBuilder .() -> Unit
): String = _TreeCellStyleBuilder(prettyPrint).apply(builder).toString()
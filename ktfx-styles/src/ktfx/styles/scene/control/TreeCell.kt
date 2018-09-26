@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import ktfx.styles.internal._TreeCellStyleBuilder

interface TreeCellStyleBuilder {

    /** The amout of space to multiply by the treeItem.level to get the left margin. */
    var indent: Number
}

inline fun treeCellStyle(
    prettyPrint: Boolean = false,
    builder: TreeCellStyleBuilder .() -> Unit
): String = _TreeCellStyleBuilder(prettyPrint).apply(builder).toString()
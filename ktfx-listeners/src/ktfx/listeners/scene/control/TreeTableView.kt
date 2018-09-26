@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.TreeTableView

/** A function which produces a TreeTableRow. */
inline fun <S> TreeTableView<S>.rowFactory(
    noinline rowFactory: TreeTableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }
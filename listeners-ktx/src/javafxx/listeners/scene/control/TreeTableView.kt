@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.TreeTableView
import javafxx.listeners.internal.build

/** A function which produces a TreeTableRow. */
inline fun <S> TreeTableView<S>.rowFactory(
    noinline rowFactory: TreeTableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }
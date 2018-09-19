@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.listeners

/* ktlint-enable package-name */

import javafx.scene.control.TableView

/** A function which produces a TableRow. */
inline fun <S> TableView<S>.rowFactory(
    noinline rowFactory: TableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }

@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.TableView

/** A function which produces a TableRow. */
inline fun <S> TableView<S>.rowFactory(
    noinline rowFactory: TableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { rowFactory.build() }

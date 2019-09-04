@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.scene.control.TableView

/** A function which produces a TableRow. */
fun <S> TableView<S>.rowFactory(
    rowFactory: TableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { rowFactory.build() }

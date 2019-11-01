@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.scene.control.TreeTableView

/** A function which produces a TreeTableRow. */
fun <S> TreeTableView<S>.rowFactory(
    rowFactory: TreeTableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { rowFactory.build() }

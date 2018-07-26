@file:Suppress("NOTHING_TO_INLINE")

package javafxx.listeners

import javafx.scene.control.TreeTableView
import javafxx.listeners.internal.build

/** A function which produces a TreeTableRow. */
inline fun <S> TreeTableView<S>.rowFactory(
    noinline rowFactory: TreeTableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }
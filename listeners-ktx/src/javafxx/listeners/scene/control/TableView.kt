@file:Suppress("NOTHING_TO_INLINE")

package javafxx.listeners

import javafx.scene.control.TableView
import javafxx.listeners.internal.build

/** A function which produces a TableRow. */
inline fun <S> TableView<S>.rowFactory(
    noinline rowFactory: TableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }

@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.TableView

inline fun <S> TableView<S>.rowFactory(
    noinline rowFactory: TableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }

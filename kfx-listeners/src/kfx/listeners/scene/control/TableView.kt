@file:Suppress("NOTHING_TO_INLINE")

package kfx.listeners

import javafx.scene.control.TableView

inline fun <S> TableView<S>.rowFactory(
    noinline rowFactory: TableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }

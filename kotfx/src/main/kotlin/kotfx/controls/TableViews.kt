@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.TableView
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun <S> tableView(
        items: ObservableList<S> = mutableObservableListOf(),
        noinline init: ((@ControlDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <S> ChildManager.tableView(
        items: ObservableList<S> = mutableObservableListOf(),
        noinline init: ((@ControlDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()
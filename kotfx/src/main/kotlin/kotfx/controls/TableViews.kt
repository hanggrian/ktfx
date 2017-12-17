@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.TableView
import kotfx.internal.ChildManager
import kotfx.internal.KotfxDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun <S> tableViewOf(
        items: ObservableList<S> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <S> ChildManager.tableView(
        items: ObservableList<S> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <S> ItemManager.tableView(
        items: ObservableList<S> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()
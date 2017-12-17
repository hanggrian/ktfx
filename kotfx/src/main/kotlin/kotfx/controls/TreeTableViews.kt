@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun <S> treeTableViewOf(
        root: TreeItem<S>? = null,
        noinline init: ((@ControlDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }

@JvmOverloads
inline fun <S> ChildManager.treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@ControlDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <S> ItemManager.treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@ControlDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()
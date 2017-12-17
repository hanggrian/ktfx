@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun <T> treeViewOf(
        root: TreeItem<T>? = null,
        noinline init: ((@ControlDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@ControlDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@ControlDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
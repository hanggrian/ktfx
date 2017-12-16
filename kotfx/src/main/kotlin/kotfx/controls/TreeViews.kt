@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun <T> treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@ControlDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@ControlDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun <T> treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@KotfxDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@KotfxDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.treeView(
        root: TreeItem<T>? = null,
        noinline init: ((@KotfxDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun <S> treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@KotfxDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }

@JvmOverloads
inline fun <S> ChildManager.treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@KotfxDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <S> ItemManager.treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@KotfxDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()
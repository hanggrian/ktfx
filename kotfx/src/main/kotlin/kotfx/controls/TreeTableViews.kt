@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun <S> treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@ControlDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }

@JvmOverloads
inline fun <S> ChildManager.treeTableView(
        root: TreeItem<S>? = null,
        noinline init: ((@ControlDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()
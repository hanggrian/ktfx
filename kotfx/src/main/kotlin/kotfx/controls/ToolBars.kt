@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.ToolBar
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun toolBarOf(
        vararg items: Node,
        noinline init: ((@ControlDsl ToolBar).() -> Unit)? = null
): ToolBar = ToolBar(*items).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.toolBar(
        vararg items: Node,
        noinline init: ((@ControlDsl ToolBar).() -> Unit)? = null
): ToolBar = ToolBar(*items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.toolBar(
        vararg items: Node,
        noinline init: ((@ControlDsl ToolBar).() -> Unit)? = null
): ToolBar = ToolBar(*items).apply { init?.invoke(this) }.add()
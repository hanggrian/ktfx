@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.ToolBar
import kotfx.controls.ItemManager
import kotfx.controls._ToolBar
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun toolBar(
        vararg items: Node,
        noinline init: ((@KotfxDsl _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.toolBar(
        vararg items: Node,
        noinline init: ((@KotfxDsl ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.toolBar(
        vararg items: Node,
        noinline init: ((@KotfxDsl ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()
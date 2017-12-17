@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.SplitPane
import kotfx.internal.ChildManager
import kotfx.internal.KotfxDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun splitPaneOf(
        vararg items: Node,
        noinline init: ((@KotfxDsl SplitPane).() -> Unit)? = null
): SplitPane = SplitPane(*items).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.splitPane(
        vararg items: Node,
        noinline init: ((@KotfxDsl SplitPane).() -> Unit)? = null
): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.splitPane(
        vararg items: Node,
        noinline init: ((@KotfxDsl SplitPane).() -> Unit)? = null
): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()
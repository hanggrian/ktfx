@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun scrollPaneOf(
        content: Node? = null,
        noinline init: ((@ControlDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.scrollPane(
        content: Node? = null,
        noinline init: ((@ControlDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.scrollPane(
        content: Node? = null,
        noinline init: ((@ControlDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()
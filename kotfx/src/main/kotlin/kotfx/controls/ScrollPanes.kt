@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun scrollPane(
        content: Node? = null,
        noinline init: ((@ControlDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.scrollPane(
        content: Node? = null,
        noinline init: ((@ControlDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()
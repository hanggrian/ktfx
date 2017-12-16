@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Tab
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun tab(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Tab).() -> Unit)? = null
): Tab = Tab(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.tab(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Tab).() -> Unit)? = null
): Tab = Tab(text, graphic).apply { init?.invoke(this) }
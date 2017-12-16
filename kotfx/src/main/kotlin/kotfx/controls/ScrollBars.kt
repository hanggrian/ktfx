@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ScrollBar
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun scrollBar(
        noinline init: ((@ControlDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.scrollBar(
        noinline init: ((@ControlDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()
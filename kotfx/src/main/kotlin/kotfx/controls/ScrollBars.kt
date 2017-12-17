@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ScrollBar
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun scrollBar(
        noinline init: ((@KotfxDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.scrollBar(
        noinline init: ((@KotfxDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.scrollBar(
        noinline init: ((@KotfxDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()
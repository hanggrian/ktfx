@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.TextArea
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun textArea(
        noinline init: ((@KotfxDsl TextArea).() -> Unit)? = null
): TextArea = TextArea().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.textArea(
        noinline init: ((@KotfxDsl TextArea).() -> Unit)? = null
): TextArea = TextArea().apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.textArea(
        noinline init: ((@KotfxDsl TextArea).() -> Unit)? = null
): TextArea = TextArea().apply { init?.invoke(this) }.add()
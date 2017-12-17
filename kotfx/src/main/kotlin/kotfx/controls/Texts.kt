@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.text.Text
import kotfx.internal.ChildManager
import kotfx.internal.KotfxDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun textOf(
        text: String? = null,
        noinline init: ((@KotfxDsl Text).() -> Unit)? = null
): Text = Text(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.text(
        text: String? = null,
        noinline init: ((@KotfxDsl Text).() -> Unit)? = null
): Text = Text(text).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.text(
        text: String? = null,
        noinline init: ((@KotfxDsl Text).() -> Unit)? = null
): Text = Text(text).apply { init?.invoke(this) }.add()
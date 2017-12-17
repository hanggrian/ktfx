@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.text.Text
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun text(
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
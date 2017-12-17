@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.RadioButton
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun radioButton(
        text: String? = null,
        noinline init: ((@KotfxDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.radioButton(
        text: String? = null,
        noinline init: ((@KotfxDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.radioButton(
        text: String? = null,
        noinline init: ((@KotfxDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()
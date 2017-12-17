@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.CheckBox
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun checkBox(
        text: String? = null,
        noinline init: ((@KotfxDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.checkBox(
        text: String? = null,
        noinline init: ((@KotfxDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.checkBox(
        text: String? = null,
        noinline init: ((@KotfxDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()
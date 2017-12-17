@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Slider
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun slider(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@KotfxDsl Slider).() -> Unit)? = null
): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.slider(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@KotfxDsl Slider).() -> Unit)? = null
): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.slider(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@KotfxDsl Slider).() -> Unit)? = null
): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()
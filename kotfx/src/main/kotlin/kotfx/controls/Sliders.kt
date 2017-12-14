@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Slider
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun slider(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@ControlDsl Slider).() -> Unit)? = null
): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.slider(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@ControlDsl Slider).() -> Unit)? = null
): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()
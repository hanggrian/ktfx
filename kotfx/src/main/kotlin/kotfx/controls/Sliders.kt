@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Orientation
import javafx.scene.control.Slider
import kotfx._Pane
import kotfx.internal.ControlDsl

class _Slider(min: Double, max: Double, value: Double) : Slider(min, max, value), _Control<Slider> {
    override val node: Slider get() = this

    fun max(value: Number) = setMax(value.toDouble())
    fun min(value: Number) = setMin(value.toDouble())
    fun value(value: Number) = setValue(value.toDouble())
    fun valueChanging(value: Boolean) = setValueChanging(value)
    fun orientation(value: Orientation) = setOrientation(value)
    fun showTickLabels(value: Boolean) = setShowTickLabels(value)
    fun showTickMarks(value: Boolean) = setShowTickMarks(value)
    fun majorTickUnit(value: Number) = setMajorTickUnit(value.toDouble())
    fun minorTickCount(value: Int) = setMinorTickCount(value)
    fun snapToTicks(value: Boolean) = setSnapToTicks(value)
    fun blockIncrement(value: Number) = setBlockIncrement(value.toDouble())
}

@JvmOverloads
inline fun sliderOf(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@ControlDsl _Slider).() -> Unit)? = null
): Slider = _Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.slider(
        min: Number,
        max: Number,
        value: Number,
        noinline init: ((@ControlDsl _Slider).() -> Unit)? = null
): Slider = sliderOf(min, max, value, init).add()
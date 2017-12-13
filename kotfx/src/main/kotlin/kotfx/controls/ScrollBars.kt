@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Orientation
import javafx.scene.control.ScrollBar
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _ScrollBar : ScrollBar(), _Control<ScrollBar> {
    override val node: ScrollBar get() = this

    fun min(value: Number) = setMin(value.toDouble())
    fun max(value: Number) = setMax(value.toDouble())
    fun value(value: Number) = setValue(value.toDouble())
    fun orientation(value: Orientation) = setOrientation(value)
    fun unitIncrement(value: Number) = setUnitIncrement(value.toDouble())
    fun blockIncrement(value: Number) = setBlockIncrement(value.toDouble())
    fun visibleAmount(value: Number) = setVisibleAmount(value.toDouble())
}

@JvmOverloads
inline fun scrollBarOf(
        noinline init: ((@ControlDsl _ScrollBar).() -> Unit)? = null
): ScrollBar = _ScrollBar().apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.scrollBar(
        noinline init: ((@ControlDsl _ScrollBar).() -> Unit)? = null
): ScrollBar = scrollBarOf(init).add()
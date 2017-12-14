@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.VPos
import javafx.scene.control.Separator
import kotfx._Pane
import kotfx.internal.ControlDsl

class _Separator : Separator(), _Control<Separator> {
    override val node: Separator get() = this

    fun orientation(value: Orientation) = setOrientation(value)
    fun halignment(value: HPos) = setHalignment(value)
    fun valignment(value: VPos) = setValignment(value)
}

@JvmOverloads
inline fun separatorOf(
        noinline init: ((@ControlDsl _Separator).() -> Unit)? = null
): Separator = _Separator().apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.separator(
        noinline init: ((@ControlDsl _Separator).() -> Unit)? = null
): Separator = separatorOf(init).add()
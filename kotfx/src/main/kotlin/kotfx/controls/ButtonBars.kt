@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ButtonBar

class _ButtonBar : ButtonBar(), _Control<ButtonBar> {
    override val control: ButtonBar get() = this
}
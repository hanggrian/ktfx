@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Spinner

class _Spinner<T> : Spinner<T>(), _Control<Spinner<T>> {
    override val node: Spinner<T> get() = this

}
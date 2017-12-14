@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Spinner
import kotfx._Pane
import kotfx.internal.ControlDsl

class _Spinner<T> : Spinner<T>(), _Control<Spinner<T>> {
    override val node: Spinner<T> get() = this

    fun editable(value: Boolean) = setEditable(value)
}

@JvmOverloads
inline fun <T> spinnerOf(
        noinline init: ((@ControlDsl _Spinner<T>).() -> Unit)? = null
): Spinner<T> = _Spinner<T>().apply { if (init != null) init() }

@JvmOverloads
inline fun <T> _Pane.spinner(
        noinline init: ((@ControlDsl _Spinner<T>).() -> Unit)? = null
): Spinner<T> = spinnerOf(init).add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.ButtonBar
import kotfx._Pane
import kotfx.internal.ControlDsl

class _ButtonBar(buttonOrder: String?) : ButtonBar(buttonOrder), _Control<ButtonBar> {
    override val node: ButtonBar get() = this

    infix fun Node.buttonData(value: ButtonData) = setButtonData(this, value)
    infix fun Node.uniformSize(value: Boolean) = setButtonUniformSize(this, value)

    fun buttonOrder(value: String) = setButtonOrder(value)
    fun buttonMinSize(value: Number) = setButtonMinWidth(value.toDouble())
}

@JvmOverloads
inline fun buttonBarOf(
        buttonOrder: String? = null,
        noinline init: ((@ControlDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.buttonBar(
        buttonOrder: String? = null,
        noinline init: ((@ControlDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = buttonBarOf(buttonOrder, init).add()
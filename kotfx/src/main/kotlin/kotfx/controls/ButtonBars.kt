@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.ButtonBar
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _ButtonBar(buttonOrder: String?) : ButtonBar(buttonOrder), _Control<ButtonBar> {
    override val control: ButtonBar get() = this

    infix fun Node.buttonData(data: ButtonData) = setButtonData(this, data)
    infix fun Node.uniformSize(uniformSize: Boolean) = setButtonUniformSize(this, uniformSize)

    fun buttonOrder(order: String) = setButtonOrder(order)
    fun buttonMinSize(width: Number) = setButtonMinWidth(width.toDouble())
}

@JvmOverloads
inline fun accordion(
        buttonOrder: String?,
        noinline init: ((@ControlDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.accordion(
        buttonOrder: String?,
        noinline init: ((@ControlDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).apply { if (init != null) init() }.add()
@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar

open class _ButtonBar(buttonOrder: String?) : ButtonBar(buttonOrder), NodeManager {

    override fun <R : Node> R.add(): R = also { buttons += it }

    /** Call [NodeManager.button] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker Button).() -> Unit
    ): Button = button(this, graphic, init)
}

/** Add a [ButtonBar] to this manager. */
fun NodeManager.buttonBar(
    buttonOrder: String? = null
): ButtonBar = _ButtonBar(buttonOrder).add()

/** Add a [ButtonBar] with initialization block to this manager. */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    init: (@LayoutDslMarker _ButtonBar).() -> Unit
): ButtonBar = (buttonBar(buttonOrder) as _ButtonBar).apply(init)

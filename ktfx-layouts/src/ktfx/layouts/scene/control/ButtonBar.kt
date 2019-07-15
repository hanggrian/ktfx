@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar

open class _ButtonBar(buttonOrder: String?) : ButtonBar(buttonOrder), NodeManager {

    override fun <R : Node> R.add(): R = also { buttons += it }

    /** Creates a [Button] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDslMarker Button).() -> Unit)? = null
    ): Button = button(this, graphic, init)
}

/** Creates a [ButtonBar]. */
fun buttonBar(
    buttonOrder: String? = null,
    init: ((@LayoutDslMarker _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).also { init?.invoke(it) }

/** Creates a [ButtonBar] and add it to this manager. */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    noinline init: ((@LayoutDslMarker _ButtonBar).() -> Unit)? = null
): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init).add()

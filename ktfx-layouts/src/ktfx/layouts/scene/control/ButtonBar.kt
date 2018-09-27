@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar

open class _ButtonBar(
    buttonOrder: String?
) : ButtonBar(buttonOrder), LayoutManager<Node> {

    override val childs: MutableCollection<Node> get() = buttons

    /** Creates a [Button] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl Button).() -> Unit)? = null
    ): Button = button(this, graphic, init)
}

/** Creates a [ButtonBar]. */
fun buttonBar(
    buttonOrder: String? = null,
    init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).also {
    init?.invoke(it)
}

/** Creates a [ButtonBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.buttonBar(
    buttonOrder: String? = null,
    noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init)()
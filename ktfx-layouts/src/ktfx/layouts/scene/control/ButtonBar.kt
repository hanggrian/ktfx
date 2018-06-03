@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar

open class _ButtonBar(
    buttonOrder: String?
) : ButtonBar(buttonOrder), LayoutManager<Node> {

    override val childs: MutableList<Node> get() = buttons

    /** Creates a [Button] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl Button).() -> Unit)? = null
    ): Button = button(this, graphic, init)

    /** Creates a styled [Button] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl Button).() -> Unit)? = null
    ): Button = styledButton(styleClass, this, graphic, init)
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

/** Create a styled [ButtonBar]. */
fun styledButtonBar(
    styleClass: String,
    buttonOrder: String? = null,
    init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ButtonBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledButtonBar(
    styleClass: String,
    buttonOrder: String? = null,
    noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = ktfx.layouts.styledButtonBar(styleClass, buttonOrder, init)()
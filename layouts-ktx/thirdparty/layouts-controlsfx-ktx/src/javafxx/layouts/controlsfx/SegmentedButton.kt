@file:Suppress("NOTHING_TO_INLINE", "ClassName", "UNCHECKED_CAST")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ToggleButton
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import javafxx.layouts.button
import javafxx.layouts.styledButton
import org.controlsfx.control.SegmentedButton

open class _SegmentedButton(
    vararg buttons: ToggleButton
) : SegmentedButton(*buttons), LayoutManager<Node> {

    override val childs: MutableList<Node> get() = buttons as MutableList<Node>

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

/** Creates a [SegmentedButton]. */
fun segmentedButton(
    vararg buttons: ToggleButton,
    init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = _SegmentedButton(*buttons).also {
    init?.invoke(it)
}

/** Creates a [SegmentedButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.segmentedButton(
    vararg buttons: ToggleButton,
    noinline init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = javafxx.layouts.controlsfx.segmentedButton(*buttons, init = init)()

/** Create a styled [SegmentedButton]. */
fun styledSegmentedButton(
    styleClass: String,
    vararg buttons: ToggleButton,
    init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = _SegmentedButton(*buttons).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SegmentedButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSegmentedButton(
    styleClass: String,
    vararg buttons: ToggleButton,
    noinline init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = javafxx.layouts.controlsfx.styledSegmentedButton(styleClass, *buttons, init = init)()
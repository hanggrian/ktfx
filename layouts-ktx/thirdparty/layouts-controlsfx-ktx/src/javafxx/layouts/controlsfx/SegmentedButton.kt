@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.SegmentedButton

open class _SegmentedButton(
    vararg buttons: ToggleButton
) : SegmentedButton(*buttons), LayoutManager<ToggleButton> {

    override val childs: MutableList<ToggleButton> get() = buttons
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
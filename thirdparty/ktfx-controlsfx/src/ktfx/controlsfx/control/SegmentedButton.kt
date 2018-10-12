@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName", "UNCHECKED_CAST")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.SegmentedButton

open class _SegmentedButton(
    vararg buttons: ToggleButton
) : SegmentedButton(*buttons), LayoutManager<Node> {

    override val childs: MutableList<Node> get() = buttons as MutableList<Node>
}

/** Creates a [SegmentedButton]. */
fun segmentedButton(
    vararg buttons: ToggleButton,
    init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = _SegmentedButton(*buttons).also { init?.invoke(it) }

/** Creates a [SegmentedButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.segmentedButton(
    vararg buttons: ToggleButton,
    noinline init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = ktfx.controlsfx.segmentedButton(*buttons, init = init)()
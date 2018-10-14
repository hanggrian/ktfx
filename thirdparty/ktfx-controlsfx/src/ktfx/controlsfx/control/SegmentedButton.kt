@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName", "UNCHECKED_CAST")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.SegmentedButton

open class _SegmentedButton(vararg buttons: ToggleButton) : SegmentedButton(*buttons), NodeManager {

    override val children: MutableCollection<Node> get() = buttons as ObservableList<Node>
}

/** Creates a [SegmentedButton]. */
fun segmentedButton(
    vararg buttons: ToggleButton,
    init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = _SegmentedButton(*buttons).also { init?.invoke(it) }

/** Creates a [SegmentedButton] and add it to this manager. */
inline fun NodeManager.segmentedButton(
    vararg buttons: ToggleButton,
    noinline init: ((@LayoutDsl _SegmentedButton).() -> Unit)? = null
): SegmentedButton = ktfx.controlsfx.segmentedButton(*buttons, init = init)()
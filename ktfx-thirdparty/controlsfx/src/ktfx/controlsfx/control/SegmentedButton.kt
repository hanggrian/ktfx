@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName", "UNCHECKED_CAST")

package ktfx.controlsfx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

open class _SegmentedButton : SegmentedButton(), ToggleButtonManager {

    override fun <R : ToggleButton> R.add(): R = also { buttons += it }

    /** Creates a [Button] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDslMarker ToggleButton).() -> Unit)? = null
    ): ToggleButton = toggleButton(this, graphic, init)
}

/** Creates a [SegmentedButton]. */
fun segmentedButton(
    init: ((@LayoutDslMarker _SegmentedButton).() -> Unit)? = null
): SegmentedButton = _SegmentedButton().also { init?.invoke(it) }

/** Creates a [SegmentedButton] and add it to this manager. */
inline fun NodeManager.segmentedButton(
    noinline init: ((@LayoutDslMarker _SegmentedButton).() -> Unit)? = null
): SegmentedButton = ktfx.controlsfx.segmentedButton(init).add()

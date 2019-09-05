@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

open class _SegmentedButton : SegmentedButton(), ToggleButtonManager {

    override fun <R : ToggleButton> R.add(): R = also { buttons += it }

    /** Call [ToggleButtonManager.toggleButton] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker ToggleButton).() -> Unit
    ): ToggleButton = toggleButton(this, graphic, init)
}

/** Add a [SegmentedButton] to this manager. */
fun NodeManager.segmentedButton(): SegmentedButton =
    _SegmentedButton().add()

/** Add a [SegmentedButton] with initialization block to this manager. */
inline fun NodeManager.segmentedButton(
    init: (@LayoutDslMarker _SegmentedButton).() -> Unit
): SegmentedButton = (segmentedButton() as _SegmentedButton).apply(init)

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import ktfx.layouts.addNode
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

open class KtfxSegmentedButton : SegmentedButton(), ToggleButtonManager {

    final override fun <T : ToggleButton> addButton(button: T): T =
        button.also { buttons += it }

    /** Call [ToggleButtonManager.toggleButton] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker ToggleButton).() -> Unit
    ): ToggleButton = toggleButton(this, graphic, init)
}

/** Create a [SegmentedButton] with initialization block. */
inline fun segmentedButton(
    init: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit
): SegmentedButton = KtfxSegmentedButton().apply(init)

/** Add a [SegmentedButton] to this manager. */
fun NodeManager.segmentedButton(): SegmentedButton =
    addNode(KtfxSegmentedButton())

/** Add a [SegmentedButton] with initialization block to this manager. */
inline fun NodeManager.segmentedButton(
    init: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit
): SegmentedButton = addNode(KtfxSegmentedButton(), init)

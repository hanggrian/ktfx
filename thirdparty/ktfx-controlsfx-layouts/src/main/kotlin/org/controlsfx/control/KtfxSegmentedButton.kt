@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.ToggleButtonContainer
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

/** [SegmentedButton] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxSegmentedButton :
    SegmentedButton(),
    ToggleButtonContainer {
    final override fun <T : ToggleButton> addChild(child: T): T = child.also { buttons += it }

    /** Call [ToggleButtonContainer.toggleButton] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
    ): ToggleButton = toggleButton(this, graphic, configuration)
}

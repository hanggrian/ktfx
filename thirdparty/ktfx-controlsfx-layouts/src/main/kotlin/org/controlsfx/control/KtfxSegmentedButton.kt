@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.ToggleButtonContainer
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

/** [SegmentedButton] with dynamic-layout dsl support. Invoking dsl will add its children. */
public open class KtfxSegmentedButton :
    SegmentedButton(),
    ToggleButtonContainer {
    final override fun <T : ToggleButton> addChild(child: T): T = child.also { buttons += it }

    /** Call [ToggleButtonContainer.toggleButton] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker ToggleButton).() -> Unit,
    ): ToggleButton = toggleButton(this, graphic, configuration)
}

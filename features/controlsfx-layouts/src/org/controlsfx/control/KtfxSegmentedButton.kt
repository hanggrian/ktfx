@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.ToggleButtonManager
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton
import kotlin.contracts.ExperimentalContracts

/**
 * [SegmentedButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxSegmentedButton : SegmentedButton(), ToggleButtonManager {

    final override fun <C : ToggleButton> addChild(child: C): C = child.also { buttons += it }

    /** Call [ToggleButtonManager.toggleButton] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker ToggleButton).() -> Unit
    ): ToggleButton = toggleButton(this, graphic, configuration)
}

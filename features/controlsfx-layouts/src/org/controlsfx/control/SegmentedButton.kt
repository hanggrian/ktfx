@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import ktfx.layouts.addChild
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

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

/** Create a [SegmentedButton] with configurationialization block. */
inline fun segmentedButton(
    configuration: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit
): SegmentedButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSegmentedButton().apply(configuration)
}

/** Add a [SegmentedButton] to this manager. */
fun NodeManager.segmentedButton(): SegmentedButton = addChild(KtfxSegmentedButton())

/** Add a [SegmentedButton] with configurationialization block to this manager. */
inline fun NodeManager.segmentedButton(
    configuration: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit
): SegmentedButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxSegmentedButton(), configuration)
}

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import ktfx.layouts.addNode
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton

/**
 * [SegmentedButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxSegmentedButton : SegmentedButton(), ToggleButtonManager {

    final override fun <T : ToggleButton> addButton(button: T): T =
        button.also { buttons += it }

    /** Call [ToggleButtonManager.toggleButton] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: ToggleButton.() -> Unit
    ): ToggleButton = toggleButton(this, graphic, init)
}

/** Create a [SegmentedButton] with initialization block. */
inline fun segmentedButton(
    init: KtfxSegmentedButton.() -> Unit
): SegmentedButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxSegmentedButton().apply(init)
}

/** Add a [SegmentedButton] to this manager. */
fun NodeManager.segmentedButton(): SegmentedButton =
    addNode(KtfxSegmentedButton())

/** Add a [SegmentedButton] with initialization block to this manager. */
inline fun NodeManager.segmentedButton(
    init: KtfxSegmentedButton.() -> Unit
): SegmentedButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxSegmentedButton(), init)
}

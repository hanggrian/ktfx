@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SegmentedButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SegmentedButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.segmentedButton(): SegmentedButton = segmentedButton() { }

/**
 * Create a [SegmentedButton] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun segmentedButton(configuration: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit):
    SegmentedButton {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxSegmentedButton()
        child.configuration()
        return child
    }

/**
 * Add a [SegmentedButton] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.segmentedButton(
    configuration: (@LayoutDslMarker KtfxSegmentedButton).() ->
    Unit
): SegmentedButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSegmentedButton()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SegmentedButton].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledSegmentedButton(vararg styleClass: String, id: String? = null): SegmentedButton =
    styledSegmentedButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SegmentedButton] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledSegmentedButton(vararg styleClass: String, id: String? = null):
    SegmentedButton = styledSegmentedButton(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SegmentedButton] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledSegmentedButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit
): SegmentedButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSegmentedButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SegmentedButton] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledSegmentedButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSegmentedButton).() -> Unit
): SegmentedButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSegmentedButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

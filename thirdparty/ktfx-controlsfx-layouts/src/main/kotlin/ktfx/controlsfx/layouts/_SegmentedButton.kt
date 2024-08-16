@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.SegmentedButton

/**
 * Add a [SegmentedButton] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.segmentedButton(): SegmentedButton = segmentedButton() { }

/**
 * Create a [SegmentedButton] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun segmentedButton(configuration: (@KtfxLayoutDslMarker
        KtfxSegmentedButton).() -> Unit): SegmentedButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSegmentedButton()
    child.configuration()
    return child
}

/**
 * Add a [SegmentedButton] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.segmentedButton(configuration: (@KtfxLayoutDslMarker
        KtfxSegmentedButton).() -> Unit): SegmentedButton {
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
public inline fun styledSegmentedButton(vararg styleClass: String, id: String? = null):
        SegmentedButton = styledSegmentedButton(styleClass = styleClass, id = id) { }

/**
 * Add a styled [SegmentedButton] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSegmentedButton(vararg styleClass: String, id: String? =
        null): SegmentedButton = styledSegmentedButton(styleClass = styleClass, id = id) { }

/**
 * Create a styled [SegmentedButton] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledSegmentedButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSegmentedButton).() -> Unit,
): SegmentedButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSegmentedButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SegmentedButton] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSegmentedButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSegmentedButton).() -> Unit,
): SegmentedButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSegmentedButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

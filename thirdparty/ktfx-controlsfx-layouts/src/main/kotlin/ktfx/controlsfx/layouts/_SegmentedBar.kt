@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

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
import org.controlsfx.control.SegmentedBar

/**
 * Add a [SegmentedBar] to this container.
 *
 * @return the control added.
 */
public fun <T : SegmentedBar.Segment> NodeContainer.segmentedBar(): SegmentedBar<T> = segmentedBar()
        { }

/**
 * Create a [SegmentedBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T : SegmentedBar.Segment> segmentedBar(configuration: (@KtfxLayoutDslMarker
        SegmentedBar<T>).() -> Unit): SegmentedBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SegmentedBar<T>()
    child.configuration()
    return child
}

/**
 * Add a [SegmentedBar] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T : SegmentedBar.Segment>
        NodeContainer.segmentedBar(configuration: (@KtfxLayoutDslMarker
        SegmentedBar<T>).() -> Unit): SegmentedBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SegmentedBar<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SegmentedBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun <T : SegmentedBar.Segment> styledSegmentedBar(vararg styleClass: String, id: String? =
        null): SegmentedBar<T> = styledSegmentedBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SegmentedBar] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun <T : SegmentedBar.Segment> NodeContainer.styledSegmentedBar(vararg styleClass: String,
        id: String? = null): SegmentedBar<T> = styledSegmentedBar(styleClass = *styleClass, id = id)
        { }

/**
 * Create a styled [SegmentedBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T : SegmentedBar.Segment> styledSegmentedBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker SegmentedBar<T>).() -> Unit,
): SegmentedBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SegmentedBar<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SegmentedBar] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T : SegmentedBar.Segment> NodeContainer.styledSegmentedBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker SegmentedBar<T>).() -> Unit,
): SegmentedBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SegmentedBar<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

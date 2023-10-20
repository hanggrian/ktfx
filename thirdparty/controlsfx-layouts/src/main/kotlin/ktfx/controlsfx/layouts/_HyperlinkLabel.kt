@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.HyperlinkLabel

/**
 * Add a [HyperlinkLabel] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.hyperlinkLabel(text: String? = null): HyperlinkLabel = hyperlinkLabel(text
        = text) { }

/**
 * Create a [HyperlinkLabel] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun hyperlinkLabel(text: String? = null, configuration: (@KtfxLayoutDslMarker
        HyperlinkLabel).() -> Unit): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.configuration()
    return child
}

/**
 * Add a [HyperlinkLabel] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.hyperlinkLabel(text: String? = null,
        configuration: (@KtfxLayoutDslMarker HyperlinkLabel).() -> Unit): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [HyperlinkLabel].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): HyperlinkLabel = styledHyperlinkLabel(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HyperlinkLabel] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): HyperlinkLabel = styledHyperlinkLabel(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HyperlinkLabel] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker HyperlinkLabel).() -> Unit,
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [HyperlinkLabel] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker HyperlinkLabel).() -> Unit,
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

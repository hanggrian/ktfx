@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.HyperlinkLabel
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [HyperlinkLabel] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.hyperlinkLabel(text: String? = null): HyperlinkLabel = hyperlinkLabel(text = text) {
}

/**
 * Create a [HyperlinkLabel] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun hyperlinkLabel(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        HyperlinkLabel
    ).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.configuration()
    return child
}

/**
 * Add a [HyperlinkLabel] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.hyperlinkLabel(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        HyperlinkLabel
    ).() -> Unit
): HyperlinkLabel {
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
fun styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): HyperlinkLabel = styledHyperlinkLabel(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HyperlinkLabel] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): HyperlinkLabel = styledHyperlinkLabel(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HyperlinkLabel] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [HyperlinkLabel] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = HyperlinkLabel(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

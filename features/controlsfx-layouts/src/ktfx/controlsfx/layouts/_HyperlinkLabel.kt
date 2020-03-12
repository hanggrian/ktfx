@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.HyperlinkLabel

/**
 * Add a [HyperlinkLabel] to this manager.
 */
fun NodeManager.hyperlinkLabel(text: String? = null): HyperlinkLabel = hyperlinkLabel(text = text) {
        }

/**
 * Create a [HyperlinkLabel] with configuration block.
 */
inline fun hyperlinkLabel(
    text: String? = null,
    configuration: (@LayoutDslMarker    
            HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(HyperlinkLabel(text), configuration = configuration)
}

/**
 * Add a [HyperlinkLabel] with configuration block to this manager.
 */
inline fun NodeManager.hyperlinkLabel(
    text: String? = null,
    configuration: (@LayoutDslMarker    
            HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(HyperlinkLabel(text), configuration = configuration))
}

/**
 * Create a styled [HyperlinkLabel].
 */
fun styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): HyperlinkLabel = styledHyperlinkLabel(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HyperlinkLabel] to this manager.
 */
fun NodeManager.styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): HyperlinkLabel = styledHyperlinkLabel(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HyperlinkLabel] with configuration block.
 */
inline fun styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(HyperlinkLabel(text), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [HyperlinkLabel] with configuration block to this manager.
 */
inline fun NodeManager.styledHyperlinkLabel(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(HyperlinkLabel(text), styleClass = *styleClass, id = id, configuration =
            configuration))
}

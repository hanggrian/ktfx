@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.HyperlinkLabel

/** Create a [HyperlinkLabel] with configuration block. */
inline fun hyperlinkLabel(
    text: String? = null,
    configuration: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return HyperlinkLabel(text).apply(configuration)
}

/** Add a [HyperlinkLabel] to this manager. */
fun NodeManager.hyperlinkLabel(
    text: String? = null
): HyperlinkLabel = addChild(HyperlinkLabel(text))

/** Add a [HyperlinkLabel] with configuration block to this manager. */
inline fun NodeManager.hyperlinkLabel(
    text: String? = null,
    configuration: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(HyperlinkLabel(text), configuration)
}

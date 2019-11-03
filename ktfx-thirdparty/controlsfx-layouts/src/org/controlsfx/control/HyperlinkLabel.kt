@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.thirdparty.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.HyperlinkLabel

/** Create a [HyperlinkLabel] with initialization block. */
inline fun hyperlinkLabel(
    text: String? = null,
    init: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel = HyperlinkLabel(text).apply(init)

/** Add a [HyperlinkLabel] to this manager. */
fun NodeManager.hyperlinkLabel(
    text: String? = null
): HyperlinkLabel = addNode(HyperlinkLabel(text))

/** Add a [HyperlinkLabel] with initialization block to this manager. */
inline fun NodeManager.hyperlinkLabel(
    text: String? = null,
    init: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel = addNode(HyperlinkLabel(text), init)

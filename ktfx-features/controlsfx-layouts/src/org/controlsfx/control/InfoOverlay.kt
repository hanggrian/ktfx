@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.InfoOverlay

/**
 * [InfoOverlay] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxInfoOverlay(graphic: Node?, text: String?) : InfoOverlay(graphic, text), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }

    final override val childCount: Int get() = if (content != null) 1 else 0
}

/** Create a [InfoOverlay] with initialization block. */
inline fun infoOverlay(
    content: Node? = null,
    text: String? = null,
    init: (@LayoutsDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxInfoOverlay(content, text).apply(init)
}

/** Add a [InfoOverlay] to this manager. */
fun NodeManager.infoOverlay(
    content: Node? = null,
    text: String? = null
): InfoOverlay = addChild(InfoOverlay(content, text))

/** Add a [InfoOverlay] with initialization block to this manager. */
inline fun NodeManager.infoOverlay(
    content: Node? = null,
    text: String? = null,
    init: (@LayoutsDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxInfoOverlay(content, text), init)
}

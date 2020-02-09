@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.InfoOverlay

/**
 * [InfoOverlay] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxInfoOverlay(graphic: Node?, text: String?) : InfoOverlay(graphic, text), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content = it }
}

/** Create a [InfoOverlay] with configurationialization block. */
inline fun infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxInfoOverlay(content, text).apply(configuration)
}

/** Add a [InfoOverlay] to this manager. */
fun NodeManager.infoOverlay(
    content: Node? = null,
    text: String? = null
): InfoOverlay = addChild(InfoOverlay(content, text))

/** Add a [InfoOverlay] with configurationialization block to this manager. */
inline fun NodeManager.infoOverlay(
    content: Node? = null,
    text: String? = null,
    configuration: (@LayoutDslMarker KtfxInfoOverlay).() -> Unit
): InfoOverlay {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxInfoOverlay(content, text), configuration)
}

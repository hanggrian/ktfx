@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxButtonBar(buttonOrder: String?) : ButtonBar(buttonOrder), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { buttons += it }

    /** Call [NodeManager.button] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker Button).() -> Unit
    ): Button = button(this, graphic, init) }

/** Create a [ButtonBar] with initialization block. */
inline fun buttonBar(
    buttonOrder: String? = null,
    init: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return KtfxButtonBar(buttonOrder).apply(init)
}
/** Add a [ButtonBar] to this manager. */
fun NodeManager.buttonBar(
    buttonOrder: String? = null
): ButtonBar = addNode(KtfxButtonBar(buttonOrder))

/** Add a [ButtonBar] with initialization block to this manager. */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    init: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(KtfxButtonBar(buttonOrder), init)
}
